package com.yedam.tfprj.client.community.web;

import com.yedam.tfprj.client.community.service.notice.CliNoticeService;
import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliNoticeController {
    @Autowired
    CliNoticeService service;

    @RequestMapping("/cli/notice") //리스트
    public String CliNoticeList(Model model, CliNoticeVO vo) {

        model.addAttribute("cliNotice", service.CliNoticeList(vo));
        return "client/community/notice/notice";
    }

    @RequestMapping("/cli/noticeDetail")
    public String NoticeDetail(Model model, CliNoticeVO vo) {
        vo.setNNo(vo.getNNo());
        System.out.println(vo.getNNo());
        model.addAttribute("notice", service.CliNoticeSelect(vo));

        return "client/community/notice/notice_detail";
    }

}
