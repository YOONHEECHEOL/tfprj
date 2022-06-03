package com.yedam.tfprj.admin.common.web;

import com.yedam.tfprj.admin.worker.service.WorkerService;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdmCommonController {
    @Autowired
    WorkerService service;

    @RequestMapping("/adm/index")
    public String admIndex() {
        return "admin/common/home";
    }

    @RequestMapping("/adm/loginview")
    public String admLogin() {
        return "admin/common/login";
    }

    @RequestMapping("/adm/loginSuccess")
    public String admLoginSuccess(WorkerVO vo, HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        if (service.loginSelect(vo) != null) {
            vo = service.loginSelect(vo);
            System.out.println("asdfasdf" + vo);
            session.setAttribute("workerId", vo.getWorkerId());
            session.setAttribute("positionCd", vo.getPositionCd());
            return "admin/common/home";
        }else{
            return null;
        }
    }
}
