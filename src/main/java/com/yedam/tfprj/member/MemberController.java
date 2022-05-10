package com.yedam.tfprj.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @RequestMapping("/memberTest")
    public String memberList() {
        return "memberTest";
    }


    @RequestMapping("/getMemberList")
    @ResponseBody
    public List<MemberVO> getMemberList(Model model) {
        return memberMapper.getMemberList();
    }

}
