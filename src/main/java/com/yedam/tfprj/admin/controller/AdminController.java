package com.yedam.tfprj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/adm/index")
    public String admIndex() {
        return "admin/page/home";
    }

    @RequestMapping("/cli/index")
    public String cliIndex() {
        return "client/page/home";
    }

    @RequestMapping("/adm/login")
    public String admLogin(){ return "admin/page/login";}

    //근무자관리
    @RequestMapping("/adm/workerManage")
    public String admWorkerManage(){ return "admin/manage/workerManage";}

    //할일관리
    @RequestMapping("/adm/todolist")
    public String admTodolist(){ return "admin/todo/todo";}

    //재고관리
    @RequestMapping("/adm/stockManage")
    public String admStockManage(){ return "admin/stock/stockManage";}

    //매출관리
    @RequestMapping("/adm/salesManage")
    public String admSalesManage(){ return "admin/sales/salesManage";}

}
