package com.yedam.tfprj.admin.workerAttendance.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import com.yedam.tfprj.admin.workerAttendance.service.PayrollVO;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceService;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceVO;
import com.yedam.tfprj.admin.workerAttendance.service.ReturnVO;
import com.yedam.tfprj.admin.worksheet.service.NewWorkSheetVO;
import com.yedam.tfprj.admin.worksheet.service.WorksheetService;
import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class WorkerAttendanceController {
    @Autowired
    WorkerAttendanceService service;

    @Autowired
    WorksheetService worksheetService;

    @Autowired
    WorkerService workerService;



    @RequestMapping("/adm/now_worker_attendance")
    public String nowWorkerAttendance(Model model){
        WorkerAttendanceVO vo = service.getNowWorker();
        if(vo == null){
            vo = new WorkerAttendanceVO();
        }
        model.addAttribute("nowWorker", vo);

        return "admin/worker/now_worker_attendance";
    }


    @ResponseBody
    @RequestMapping("/adm/jsonSheetList")
    public List<WorksheetVO> jsonSheetList(){
        System.out.println("리스트 : " + worksheetService.worksheetList());
        return worksheetService.worksheetList();
    }

    @ResponseBody
    @PostMapping("/adm/insertAttendance")
    public ReturnVO insertAttendance(String workerId, long getNowTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm");

        ReturnVO rVo = new ReturnVO();
        System.out.println("근무자" + workerId);

        //출근 Insert 하기 전 출근시간 Validation
        WorksheetVO wVo =  worksheetService.validateWorkTime(workerId);

        if(wVo == null){
            rVo.setLate("3");
            return rVo;
        }else{
            Date goInTime = formatter.parse(formatter.format(wVo.getGoingTime()));
            System.out.println("가는시간 밀리sec" + goInTime.getTime());
            System.out.println("현재시간 밀리sec" + getNowTime);
            long difference = (goInTime.getTime() - getNowTime) / 60000;
            System.out.println("두시간 차이 " + difference);

            //출근 Insert, 현재 시간과, 워크시트에 정해져 있는 출근시간의 차이가 60분 일찍 이상이면 출근이 안되게,
            //오늘 출근한 사람은 한번 더 출근하지 못하게.
            service.selectQuitTime(workerId);
            System.out.println("ㅋㅋ " +service.selectQuitTime(workerId));
            if(difference > -150 && difference < 60) {
                service.insertAttendance(workerId);
            }else{
                return null;
            }


            WorkerAttendanceVO vo = service.getPercent(workerId);
            rVo.setVo(vo);

            //rVo에 근무자 정보 조회한 값을 담음
            rVo.setTime(service.getSecond(workerId).getGetTime());

            // inTime = String 타입인데 Date 타입으로 변환 후 실제출근시간, 원래출근시간의 차이를 '분'으로 구하기

            Date date = formatter.parse(vo.getInMTime());
            long minute = (vo.getGoingTime().getTime() - date.getTime()) / 60000;
            System.out.println("원래출근시간 : " + vo.getGoingTime());
            System.out.println("실제출근시간 : " + date);
            System.out.println("원래출근시간 - 실제출근시간 :" + minute + "분");
            rVo.setMinute(minute);

            // 정상출근
            if(minute > -10 && difference < 59) {
                rVo.setLate("0");
                return rVo;
                // 만약 실제 출근시간이 10분 이상, 120분 이하 늦게될때 지각처리
            }else if(minute <= -10 && minute >= -119){
                service.updateIslate(workerId);
                rVo.setLate("1");
                return rVo;
                // 실제 출근시간이 120분 이상 늦어질때 결근처리
            }else if(minute < -120){
                rVo.setAbsence("1");
                service.updateIsAbsence(workerId);
                return rVo;
            }
        }
        return rVo;
    }

    @ResponseBody
    @RequestMapping("/adm/updateQuit")
    public void updateQuit(String workerId){
        service.updateQuit(workerId);
    }

    @ResponseBody
    @RequestMapping("/adm/selectInUser")
    public ReturnVO selectInUser(String workerId) throws ParseException {
        ReturnVO rVo = new ReturnVO();
        WorkerAttendanceVO vo = service.getPercent(workerId);

        rVo.setVo(vo);
        return rVo;
    }

    @ResponseBody
    @RequestMapping("/adm/selectQuitTime")
    public List<WorkerAttendanceVO> selectQuitTime(String workerId){
        return service.selectQuitTime(workerId);
    }

    @RequestMapping("/adm/work_record")
    public String workRecord()  {
        return "admin/worker/work_record";
    }

    @ResponseBody
    @RequestMapping("/adm/getWeekList")
    public List<WorkerAttendanceVO> getWeekList(){
        return service.selectStaffInOutWeek();
    }

    @ResponseBody
    @PostMapping("/adm/allLate")
    public WorkerAttendanceVO allLate(String workerId){
        WorkerAttendanceVO vo = service.allLate(workerId);
        int isLate = vo.getIsLate();
        int isAbsence = vo.getIsAbsence();
        workerService.updateAllLateAbsence(isLate, isAbsence, workerId);
        return vo;
    }

    @ResponseBody
    @PostMapping("/adm/weekLate")
    public WorkerAttendanceVO weekLate(String workerId){
        return service.weekLate(workerId);
    }

    @ResponseBody
    @PostMapping("/adm/monthLate")
    public WorkerAttendanceVO monthLate(String workerId){
        return service.monthLate(workerId);
    }

    @ResponseBody
    @PostMapping("/adm/allAbsence")
    public WorkerAttendanceVO allAbsence(String workerId){
        return service.allAbsence(workerId);
    }

    @ResponseBody
    @RequestMapping("/adm/notInValidation")
    public void notInValidation(){
        List<NewWorkSheetVO> list = worksheetService.yesterDayWorker();
        for(int i=0; i<list.size(); i++){
            String workerId = list.get(i).getWorkerId();
            String dated = list.get(i).getDated();

            if(service.selectNotInWorker(workerId, dated).size() == 0){
                service.insertNotInWorker(workerId, dated);
            }
        }
    }



    @ResponseBody
    @RequestMapping("/adm/lastMonthPay")
    public float lastMonthPay(@RequestParam String workerId, @RequestParam String firstDate ,@RequestParam String lastDate) {
        List<WorkerAttendanceVO> list = service.lastMonthPay(workerId, firstDate, lastDate);
        int allWorkTime = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getInTime() != null && !list.get(i).getInTime().equals("결근") && list.get(i).getOutTime() != null){

                String strInTime = list.get(i).getInTime();
                String strOutTime = list.get(i).getOutTime();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
                LocalDateTime inDate = LocalDateTime.parse(strInTime, formatter);
                LocalDateTime outDate = LocalDateTime.parse(strOutTime, formatter);

                long inMilSec = inDate.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();
                long outMilSec = outDate.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();

                float time = outMilSec - inMilSec;
                allWorkTime += time;

            }
        }
        //payId = 시퀀스 SEQ.PAYROLL.nextval
        //workerId = 근무자아이디 workerId
        //wage = 총 급여 allWorkTime * workerService.getWorker(workerId).getPayPerHour()
        //work_dt = 저번달 1일 넣기 걍 firstDate
        //workTime = 지난 달 총 근무시간 allWorkTime
        //H_wage = 근무자에게 설정된 급여 workerService.getWorker(workerId).getPayPerHour()
        //payments_date = 급여 지급일 매달 10일, if문으로 10일이 됐을때 지난달의 급여를 한번만 insert 해줌
        PayrollVO pVo = new PayrollVO();

        pVo.setWorkerId(workerId);
        pVo.setFirstDate(firstDate);
        pVo.setHWage(workerService.getWorker(workerId).getPayPerHour());
        pVo.setAllWorkTime(Math.round(allWorkTime / 1000 / 60 / 60));
        pVo.setWage(Math.round((allWorkTime / 1000 / 60 / 60) * workerService.getWorker(workerId).getPayPerHour()));

        if(service.selectPayroll(pVo) == null) {
            service.insertPayroll(pVo);
        }

        float lastMonthPay = service.selectPayroll(pVo).getWage();
        float allPay = service.selectSumPayroll(pVo).getWage();

        workerService.updateLastMonthPay(workerId, lastMonthPay);
        workerService.updateSumPay(workerId, allPay);

        workerService.getWorker(workerId);

        return allPay;
    }

    @ResponseBody
    @RequestMapping("/adm/getNowWorker")
    public WorkerAttendanceVO getNowWorker(){
        return service.getNowWorker();
    }
}
