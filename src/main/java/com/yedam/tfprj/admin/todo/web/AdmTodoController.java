package com.yedam.tfprj.admin.todo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmTodoController {
    @RequestMapping("/adm/todo")
    public String admTodoManage(){
        return "admin/todo/todo";
    }
}