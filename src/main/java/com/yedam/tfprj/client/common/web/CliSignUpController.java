package com.yedam.tfprj.client.common.web;

import com.yedam.tfprj.client.common.mapper.MemberService;
import com.yedam.tfprj.client.common.mapper.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CliSignUpController {

    @Autowired
    MemberService Service;

    @GetMapping("/SignUp")
    public String SignUp(Model model , MemberVO vo){
        return "client/common/signup";
    }

    @PostMapping("/SignUp")
    public String insert(Model model , MemberVO vo){
        Service.insertClient(vo);
        return "redirect:login";
    }
}
