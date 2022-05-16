package com.yedam.tfprj.admin.common.web;

import com.yedam.tfprj.admin.worker.mapper.WorkerVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmCommonController {

    @RequestMapping("/adm/index")
    public String admIndex() {
        return "admin/common/home";
    }

    @RequestMapping("/adm/login")
    public String admLogin(){
        return "admin/common/login";
    }

    @RequestMapping("/adm/loginSuccess")
    public String admLoginSuccess(WorkerVO vo, Model model){
        model.addAttribute(vo.getWorkerName());
        return "admin/common/home";
    }
}
