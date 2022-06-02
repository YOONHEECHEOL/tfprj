package com.yedam.tfprj.admin.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.admin.community.service.notice.AdmNoticeService;
import com.yedam.tfprj.admin.community.service.notice.AdmNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdmNoticeController {

    @Autowired
    AdmNoticeService service;

    @RequestMapping("/adm/notice") //리스트
    public String AdmNoticeList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, AdmNoticeVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<AdmNoticeVO> pageInfo = new PageInfo<AdmNoticeVO>(service.AdmNoticeList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "admin/community/notice/notice";
    }

    @RequestMapping("/adm/noticeDetail")
    public String NoticeDetail(Model model, AdmNoticeVO vo) {
        service.AdmNoticeViewCount(vo.getNNo());
        vo.setNNo(vo.getNNo());
        System.out.println(vo.getNNo());
        model.addAttribute("notice", service.AdmNoticeSelect(vo));

        return "admin/community/notice/notice_detail";
    }

    @RequestMapping(value = "/adm/noticeDelete", method = RequestMethod.GET)
    public String noticeDelete(AdmNoticeVO vo) {
        service.AdmNoticeDelete(vo);
        vo.setNNo(vo.getNNo());
        return "redirect:/adm/notice";
    }

    @RequestMapping(value = "/adm/noticeUpdate", method = RequestMethod.POST)
    public String noticeUpdate(Model model, AdmNoticeVO vo) {

        model.addAttribute("notice", service.AdmNoticeSelect(vo));

        return "admin/community/notice/notice_update";
    }
    @RequestMapping("/adm/noticeUpdateForm")
    public String AdmNoticeUpdate(Model model, AdmNoticeVO vo){

        service.AdmNoticeUpdate(vo);

        return "redirect:/adm/notice";
    }


    @RequestMapping("/adm/noticeWrite")
    public String AdmNoticeWrite(Model model, AdmNoticeVO vo) {
        model.addAttribute("notice", vo);
        return "/admin/community/notice/notice_write";
    }

    @RequestMapping("/adm/noticeInsert")
    public String AdmNoticeInsert(Model model, AdmNoticeVO vo){
        System.out.println(vo);
        service.AdmNoticeInsert(vo);
        return "redirect:/adm/notice";
    }

}
