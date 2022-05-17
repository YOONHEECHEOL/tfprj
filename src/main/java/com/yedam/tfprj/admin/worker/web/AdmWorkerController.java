package com.yedam.tfprj.admin.worker.web;

import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmWorkerController {
    @Autowired
    WorkerService workerServiceImpl;
    @RequestMapping("/adm/worker_attendance")
    public String admWorkerAttendance(){
        return "admin/worker/worker_attendance";
    }

    @RequestMapping("/adm/worker_hrm")
    public String admWorkerHrm(){
        return "admin/worker/worker_hrm";
    }

    @RequestMapping("/adm/worker_hrm_detail")
    public String admWorkerHrmDetail(){
        return "admin/worker/worker_hrm_detail";
    }

    @PostMapping("/adm/worker_hrm_detail_write")
    public String admWorkerHrmWrite(WorkerVO vo){
        System.out.println(vo);
        return "admin/worker/worker_hrm";
    }

    @RequestMapping("/adm/workerManage")
    public String admWorkerManage(){
        return "admin/worker/worker_manage";
    }

    @RequestMapping("/adm/worker_plan")
    public String admWorkerPlan(){
        return "admin/worker/worker_plan";
    }
}
