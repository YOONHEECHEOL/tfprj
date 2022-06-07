package com.yedam.tfprj.admin.worker.web;

import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worker.service.WorkerServiceImpl;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdmWorkerRestController {
    @Autowired
    WorkerService workerServiceImpl;

    @GetMapping("/adm/worker_hrm_list")
    public List<WorkerVO> workerHrmList() {
        return workerServiceImpl.getWorkerList();
    }

    @GetMapping("/adm/worker_hrm_staffStatusCd_update")
    public WorkerVO workerUpdate(WorkerVO vo) {
        workerServiceImpl.staffStatusCdUpdate(vo);
        return vo;
    }

    @GetMapping("/adm/worker_hrm_list_staffCd1")
    public List<WorkerVO> workerHrmListStaffCd1(){
        return workerServiceImpl.getWorkerListStaffCd1();
    }

    @RequestMapping("/adm/isIdCheck")
    public String isIdCheck(@RequestParam String workerId){
        if(workerServiceImpl.isIdCheck(workerId) == null){
            return "n";
        }else{
            return "y";
        }
    }

}
