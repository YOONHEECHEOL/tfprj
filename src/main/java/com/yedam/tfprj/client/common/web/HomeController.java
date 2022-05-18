package com.yedam.tfprj.client.common.web;

import com.yedam.tfprj.client.common.service.CodeVO;
import com.yedam.tfprj.client.common.service.ConvertCommonCodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    ConvertCommonCodeService convertCommonCodeServiceImpl;

    @RequestMapping("/")
    public String toHome() {
        return "redirect:/cli/home";
    }

    @RequestMapping("/cli/home")
    public String toClientHome(HttpServletRequest request) {
        // login 임시 체크
        HttpSession session = request.getSession();

        if(session.getAttribute("log") == null) {
            session.setAttribute("log", "null");
        }
        return "client/common/home";
    }

    @RequestMapping(value = "/convertCommonCode", method = RequestMethod.GET)
    @ResponseBody
    public CodeVO convertCommonCode(@RequestParam(value = "code") String code) {

        return convertCommonCodeServiceImpl.convertCode(code);
    }

}
