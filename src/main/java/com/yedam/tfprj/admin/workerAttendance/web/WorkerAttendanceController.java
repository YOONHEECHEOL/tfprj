package com.yedam.tfprj.admin.workerAttendance.web;

import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkerAttendanceController {
    @Autowired
    WorkerAttendanceService service;

    @RequestMapping("/adm/now_worker_attendance")
    public String nowWorkerAttendance(Model model){
        model.addAttribute("nowWorker", service.getNowWorker());
        return "admin/worker/now_worker_attendance";
    }
}
