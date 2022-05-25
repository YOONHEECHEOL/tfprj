package com.yedam.tfprj.admin.worksheet.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import com.yedam.tfprj.admin.worksheet.service.NewWorkSheetVO;
import com.yedam.tfprj.admin.worksheet.service.WorkerArrVO;
import com.yedam.tfprj.admin.worksheet.service.WorksheetService;
import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class WorksheetRestController {
    @Autowired
    WorksheetService service;

    @RequestMapping("/adm/worksheet_list")
    public String calendarJson() {
        return service.jsonSheetList();
    }

    @RequestMapping("/adm/worksheetInsert")
    public String worksheetInsert(@RequestParam String workerArr, @RequestParam String date) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate;
        String endDate;

        try {
            List<WorkerArrVO> list = Arrays.asList(objectMapper.readValue(workerArr, WorkerArrVO[].class));
            WorkerArrVO vo;

            String dateListArr[] = list.get(0).getRealDate().split("-");

            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(dateListArr[0]), Integer.parseInt(dateListArr[1]) - 1, 1);
            int monthLength = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            //dateListArr[0] = 2022
            //dateListArr[1] = 5
            //monthLength = 해당 년, 월의 배열을 가져와서 해당 월의 일수를 계산함.

            if (dateListArr[1].length() == 1) {
                // 해당 월이 1~9월, 즉 숫자가 1일때
                for (int j = 0; j < list.size(); j++) {
                    vo = list.get(j);
                    //WorkerArrVO List의 갯수만큼 반복문
                    for (int i = 1; i <= monthLength; i++) {
                        String realDate;
                        if (i < 10) {
                            realDate = dateListArr[0] + "-0" + dateListArr[1] + "-0" + i;
                        } else {
                            realDate = dateListArr[0] + "-0" + dateListArr[1] + "-" + i;
                        }
                        vo.setRealDate(realDate);
                        //해당 월의 일수의 크기만큼 반복문을 돌림. ex)'realDate' 변수 안에 2022-05-01 ~ 2022-05-31 까지 담아놓음.

                        if(vo.getUserType().equals("0")){
                            startDate = realDate + " 13:00:00";
                            endDate = realDate + " 19:30:00";

                            //if문 사용해서 list.getUserType이 0(1부)일때는 vo.setGoingTime을 13:00, vo.setQuittingTime을 19:30으로 설정
                            //그 반대도 설정해서 vo에 넣어주면 됨.

                            try {
                                Date realStartdate = formatter.parse(startDate);
                                Date realEnddate = formatter.parse(endDate);
                                vo.setGoingTime(realStartdate);
                                vo.setQuittingTime(realEnddate);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }else{
                            startDate = realDate + " 19:30:00";
                            endDate = realDate + " 23:59:00";
                            try {
                                Date realStartdate = formatter.parse(startDate);
                                Date realEnddate = formatter.parse(endDate);
                                vo.setGoingTime(realStartdate);
                                vo.setQuittingTime(realEnddate);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                        }

                        String firstDate = dateListArr[0] + "-0" + dateListArr[1] + "-01";
                        String lastDate = dateListArr[0] + "-0" + dateListArr[1] + "-" + monthLength;
                        if(service.sheetValidation(firstDate, lastDate).size() < monthLength * 2) {
                            service.insertWorksheet(vo);
                            /* 해당 월의 첫번째 일과, 해당 월의 마지막번째 일을 각각 매개변수로 담아 크기를 계산,
                               하루에 스케쥴이 두번 들어가니 monthLength * 2로 크기를 비교 후, 해당 월의 데이터가 이미 입력되어 있을 경우
                               else문을 타서 '0'을 리턴하게됨. */
                        }else{
                            return "0";
                        }

                    }
                }
            } else {
                // 해당 월이 10~12월 일때
                for (int j = 0; j < list.size(); j++) {
                    vo = list.get(j);
                    System.out.println("asdf" + vo.getUserType());
                    for (int i = 1; i <= monthLength; i++) {
                        String realDate;
                        if (i < 10) {
                            realDate = dateListArr[0] + "-" + dateListArr[1] + "-0" + i;
                        } else {
                            realDate = dateListArr[0] + "-" + dateListArr[1] + "-" + i;
                        }
                        vo.setRealDate(realDate);

                        if(vo.getUserType().equals("0")){
                            startDate = realDate + " 13:00:00";
                            endDate = realDate + " 19:30:00";

                            try {
                                Date realStartdate = formatter.parse(startDate);
                                Date realEnddate = formatter.parse(endDate);
                                vo.setGoingTime(realStartdate);
                                vo.setQuittingTime(realEnddate);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }else{
                            startDate = realDate + " 19:30:00";
                            endDate = realDate + " 23:59:00";
                            try {
                                Date realStartdate = formatter.parse(startDate);
                                Date realEnddate = formatter.parse(endDate);
                                vo.setGoingTime(realStartdate);
                                vo.setQuittingTime(realEnddate);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        String firstDate = dateListArr[0] + "-" + dateListArr[1] + "-01";
                        String lastDate = dateListArr[0] + "-" + dateListArr[1] + "-" + monthLength;

                        if(service.sheetValidation(firstDate, lastDate).size() < monthLength * 2) {
                            service.insertWorksheet(vo);
                        }else{
                            return "0";
                        }
                    }
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<WorksheetVO> workList = service.worksheetList();
        List<Map<String, Object>> jsonList = new ArrayList<>();
        Map<String, Object> map;

        for(int i=0; i<workList.size(); i++){
            map = new HashMap<String, Object>();
            map.put("title", workList.get(i).getWorkerId());
            map.put("start", workList.get(i).getGoingTime());
            map.put("end", workList.get(i).getQuittingTime());

            jsonList.add(map);
        }

        objectMapper = new ObjectMapper();
        String strJsonList = "";
        try {
            strJsonList = objectMapper.writeValueAsString(jsonList);
            System.out.println("리턴타입 JSON" + strJsonList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return strJsonList;
        //캘린더에 동적으로 날짜를 입력해주기 위해 타입을 맞춰준 후 리턴.
    }

    @PostMapping("/adm/calendarUpdate")
    public String calendarUpdate(@RequestParam String workerId, @RequestParam String goingTime, @RequestParam String quittingTime,
                                 @RequestParam String color,    @RequestParam String textColor, @RequestParam String backgroundColor) {
        service.updateWorksheet(workerId, goingTime, quittingTime, color, textColor, backgroundColor);
        return null;
    }

    @RequestMapping("/adm/selectNextWorker")
    public List<NewWorkSheetVO> selectNextWorker(){
        return service.selectNextWorker();
    }

}

