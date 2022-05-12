package com.yedam.tfprj.admin.stock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmStockController {
    @RequestMapping("/adm/stockManage")
    public String admStockManage(){
        return "admin/stock/stock_manage";
    }
}
