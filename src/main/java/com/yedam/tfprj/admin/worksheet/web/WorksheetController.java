package com.yedam.tfprj.admin.worksheet.web;

import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worksheet.service.WorksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorksheetController {
    @Autowired
    WorksheetService service;
    @Autowired
    WorkerService workerService;

    @RequestMapping("/adm/worksheet")
    public String worksheet(Model model){
        model.addAttribute("allWorker", workerService.allWorkerList());
        return "admin/worker/worksheet";
    }
}
