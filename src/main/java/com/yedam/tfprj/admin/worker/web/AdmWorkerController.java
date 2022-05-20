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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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

    @PostMapping("/adm/worker_hrm_detail_write")
    public void admWorkerHrmWrite(@RequestParam String staffStatusCd,
                                  @RequestParam String birth,
                                  WorkerVO vo,
                                  MultipartFile file,
                                  HttpServletResponse response)
                                  throws IOException, ParseException {
//        System.out.println(vo);

        workerServiceImpl.admWorkerHrmWrite(vo, file, birth, response);
    }

    @PostMapping("/adm/worker_hrm_detail_update")
    public void admWorkerHrmDetailUpdate(@RequestParam String staffStatusCd,
                                         @RequestParam String birth ,
                                         HttpServletResponse response,
                                         MultipartFile file,
                                         WorkerVO vo)
                                         throws IOException, ParseException {

        workerServiceImpl.workerDetailUpdate(staffStatusCd, birth, response, file, vo);
    }

    @RequestMapping("/adm/worker_excel")
    public CommonExcelView excel(Model model){
        String[] header = {"workerId", "staffStatusCd", "workerName"};
        model.addAttribute("headers", header);
        model.addAttribute("filename", "workerList");
        model.addAttribute("datas", workerServiceImpl.getExecl());
        return new CommonExcelView();
    }
}
