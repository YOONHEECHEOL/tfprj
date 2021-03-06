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

    @RequestMapping("/adm/deleteCalendar")
    public String deleteCalendar(String date){

        String dateListArr[] = date.split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(dateListArr[0]), Integer.parseInt(dateListArr[1]) - 1, 1);
        int monthLength = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        String month = ("0" + dateListArr[1]);

        if(month.length() == 2){
            String firstDate = dateListArr[0] + "-" + month + "-01";
            String lastDate = dateListArr[0] + "-" + month + "-" +monthLength;

            if(service.checkDateBeforeDelete(firstDate, lastDate).size() == 0) {
                return "0";
            }else{
                service.deleteCalendar(firstDate, lastDate);
            }
        }else{
            month = month.substring(1,3);
            String firstDate = dateListArr[0] + "-" + month + "-01";
            String lastDate = dateListArr[0] + "-" + month + monthLength;

            if(service.checkDateBeforeDelete(firstDate, lastDate).size() == 0) {
                return "0";
            }else{
                service.deleteCalendar(firstDate, lastDate);
            }
        }
        return null;
    }

    @RequestMapping("/adm/worksheetInsert")
    public String worksheetInsert(@RequestParam String workerArr, @RequestParam String date) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate;
        String endDate;
        int monthLength;
        String realDate = null;

        try {
            List<WorkerArrVO> list = Arrays.asList(objectMapper.readValue(workerArr, WorkerArrVO[].class));
            WorkerArrVO vo;

            String dateListArr[] = list.get(0).getRealDate().split("-");

            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(dateListArr[0]), Integer.parseInt(dateListArr[1]) - 1, 1);
            monthLength = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            //dateListArr[0] = 2022
            //dateListArr[1] = 5
            //monthLength = ?????? ???, ?????? ????????? ???????????? ?????? ?????? ????????? ?????????.


            if (dateListArr[1].length() == 1) {
                // ?????? ?????? 1~9???, ??? ????????? 1??????
                for (int j = 0; j < list.size(); j++) {
                    vo = list.get(j);
                    //WorkerArrVO List??? ???????????? ?????????
                    for (int i = 1; i <= monthLength; i++) {

                        if (i < 10) {
                            realDate = dateListArr[0] + "-0" + dateListArr[1] + "-0" + i;
                        } else {
                            realDate = dateListArr[0] + "-0" + dateListArr[1] + "-" + i;
                        }
                        vo.setRealDate(realDate);
                        //?????? ?????? ????????? ???????????? ???????????? ??????. ex)'realDate' ?????? ?????? 2022-05-01 ~ 2022-05-31 ?????? ????????????.

                        if(vo.getUserType().equals("0")){
                            startDate = realDate + " 13:00:00";
                            endDate = realDate + " 19:30:00";

                            //if??? ???????????? list.getUserType??? 0(1???)????????? vo.setGoingTime??? 13:00, vo.setQuittingTime??? 19:30?????? ??????
                            //??? ????????? ???????????? vo??? ???????????? ???.

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
                            /* ?????? ?????? ????????? ??????, ?????? ?????? ??????????????? ?????? ?????? ??????????????? ?????? ????????? ??????,
                               ????????? ???????????? ?????? ???????????? monthLength * 2??? ????????? ?????? ???, ?????? ?????? ???????????? ?????? ???????????? ?????? ??????
                               else?????? ?????? '0'??? ???????????????. */
                        }else{
                            return "0";
                        }
                    }
                }
                System.out.println("??????" + realDate.substring(0,7).concat("-01"));
                System.out.println("?????????" +  realDate);
                service.updateWeekend(realDate.substring(0,7).concat("-01"), realDate);
                // ????????? update??? ???????????? ????????? ????????????..

            } else {
                // ?????? ?????? 10~12??? ??????
                for (int j = 0; j < list.size(); j++) {
                    vo = list.get(j);
                    System.out.println("asdf" + vo.getUserType());
                    for (int i = 1; i <= monthLength; i++) {
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
                service.updateWeekend(realDate.substring(0,7).concat("-01"), realDate);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        List<WorksheetVO> workList = service.worksheetList();
//        List<Map<String, Object>> jsonList = new ArrayList<>();
//        Map<String, Object> map;
//
//        for(int i=0; i<workList.size(); i++){
//            map = new HashMap<String, Object>();
//            map.put("title", workList.get(i).getWorkerId());
//            map.put("start", workList.get(i).getGoingTime());
//            map.put("end", workList.get(i).getQuittingTime());
//
//            jsonList.add(map);
//        }
//
//        String strJsonList = "";
//        try {
//            strJsonList = objectMapper.writeValueAsString(jsonList);
//            System.out.println("???????????? JSON" + strJsonList);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        return "1";
        //???????????? ???????????? ????????? ??????????????? ?????? ????????? ????????? ??? ??????.
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

