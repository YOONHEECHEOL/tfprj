package com.yedam.tfprj.client.common.web;


import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CliSignUpController {

    @Autowired
    MemberService Service;


}
