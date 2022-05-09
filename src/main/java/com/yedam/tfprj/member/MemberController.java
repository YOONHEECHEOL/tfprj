package com.yedam.tfprj.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping("/memberTest")
    public String memberList() {
        return "memberTest";
    }


//    @RequestMapping("/getMemberList")
//    @ResponseBody
//    public List<MemberVO> getMemberList(Model model) {
//        return dao.getMemberList();
//    }

}
