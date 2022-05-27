package com.yedam.tfprj.client.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.community.service.notice.CliNoticeService;
import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CliNoticeController {
    @Autowired
    CliNoticeService service;

    @RequestMapping("/cli/notice") //리스트
    public String CliNoticeList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, CliNoticeVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CliNoticeVO> pageInfo = new PageInfo<CliNoticeVO>(service.CliNoticeList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "client/community/notice/notice";
    }

    @RequestMapping("/cli/noticeDetail")
    public String NoticeDetail(Model model, CliNoticeVO vo) {
        service.CliNoticeViewCount(vo.getNNo());
        vo.setNNo(vo.getNNo());
        System.out.println(vo.getNNo());
        model.addAttribute("notice", service.CliNoticeSelect(vo));

        return "client/community/notice/notice_detail";
    }

}
