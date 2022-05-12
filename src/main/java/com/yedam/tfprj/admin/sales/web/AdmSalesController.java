package com.yedam.tfprj.admin.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmSalesController {
    @RequestMapping("/adm/salesManage")
    public String admSalesManage(){
        return "admin/sales/sales_manage";
    }
}
