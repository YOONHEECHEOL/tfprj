package com.yedam.tfprj.admin.worksheet.web;


import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import com.yedam.tfprj.admin.worksheet.service.WorksheetService;
import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorksheetRestController {
    @Autowired
    WorksheetService service;

    @RequestMapping("/adm/worksheet_list")
    public String calendarJson(){
        return service.jsonSheetList();
    }

    @RequestMapping("/adm/worksheetInsert")
    public WorksheetVO worksheetInsert(WorksheetVO vo){
        System.out.println();
        return null;
    }
}
