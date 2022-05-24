package com.yedam.tfprj.admin.workerAttendance.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceService;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceVO;
import com.yedam.tfprj.admin.worksheet.service.WorksheetService;
import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class WorkerAttendanceController {
    @Autowired
    WorkerAttendanceService service;

    @Autowired
    WorksheetService worksheetService;


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
    public WorkerAttendanceVO insertAttendance(String workerId){
        System.out.println("근무자" + workerId);
        service.insertAttendance(workerId);
        return null;
    }

    @RequestMapping("/adm/work_record")
    public String workRecord(){
        return "admin/worker/work_record";
    }
}
