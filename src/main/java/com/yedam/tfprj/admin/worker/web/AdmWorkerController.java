package com.yedam.tfprj.admin.worker.web;

import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    @GetMapping("/adm/worker_hrm_detail_read")
    public String admWorkerHrmDetailRead(@RequestParam String workerId, Model model){
        System.out.println(workerServiceImpl.getWorker(workerId));
        model.addAttribute("workerInfo", workerServiceImpl.getWorker(workerId));
        return "admin/worker/worker_hrm_detail_read";
    }

    @PostMapping("/adm/worker_hrm_detail_update")
    public String admWorkerHrmDetailUpdate(@RequestParam String staffStatusCd, HttpServletResponse response, WorkerVO vo) throws IOException {
        System.out.println("호출확인");
        System.out.println(vo.getGender());
        vo.setStaffStatusCd(Integer.parseInt(staffStatusCd));
        workerServiceImpl.workerDetailUpdate(vo);
        PrintWriter out = response.getWriter();
        out.println("<script>window.close()</script> ");
        // 자바스크립트에서 window.close()를 사용할 경우 데이터를 submit 하기전에 window.close()가 실행되기 때문에,
        // 컨트롤러에서 스크립트 코드 사용
        return null;
    }
}
