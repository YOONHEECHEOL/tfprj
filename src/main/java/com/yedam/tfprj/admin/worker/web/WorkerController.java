package com.yedam.tfprj.admin.worker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkerController {
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

    @RequestMapping("/adm/workerManage")
    public String admWorkerManage(){
        return "admin/worker/worker_manage";
    }

    @RequestMapping("/adm/worker_plan")
    public String admWorkerPlan(){
        return "admin/worker/worker_plan";
    }
}
