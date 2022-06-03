package com.yedam.tfprj.admin.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.admin.community.service.fm.AdmFmService;
import com.yedam.tfprj.admin.community.service.fm.AdmFmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdmFmController {
    @Autowired
    AdmFmService service;

    @RequestMapping("/adm/fm")
    public String AdmFmList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, AdmFmVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<AdmFmVO> pageInfo = new PageInfo<AdmFmVO>(service.AdmFmList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "admin/community/fm/fm";
    }

    @RequestMapping("/adm/fmDetail")
    public String fmDetail(Model model, AdmFmVO vo) {
        service.AdmFmViewCount(vo.getFNo());
        vo.setFNo(vo.getFNo());
        model.addAttribute("fm", service.AdmFmSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.AdmReplyList(vo)); // 코맨트 리스트
        return "admin/community/fm/fm_detail";
    }

    @RequestMapping("/adm/fmAnswerInsert")
    public String fmAnswerInsert(Model model, AdmFmVO vo) {
        service.AdmFmAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/adm/fmDetail?fNo=" + vo.getFNo();
    }

    @RequestMapping(value = "/adm/fmDelete", method = RequestMethod.GET)
    public String fmDelete(AdmFmVO vo) {
        service.AdmFmDelete(vo);
        vo.setFNo(vo.getFNo());
        return "redirect:/adm/fm";
    }

    @RequestMapping(value = "/adm/fmUpdate", method = RequestMethod.POST)
    public String fmUpdate(Model model, AdmFmVO vo) {
        model.addAttribute("fm", service.AdmFmSelect(vo));

        return "admin/community/fm/fm_update";
    }

    @RequestMapping("/adm/fmUpdateForm")
    public String AdmFmUpdate(Model model, AdmFmVO vo) {
        service.AdmFmUpdate(vo);
        return "redirect:/adm/fm";
    }


    @RequestMapping("/adm/fmWrite")
    public String AdmFmWrite(Model model, AdmFmVO vo) {
        model.addAttribute("fm", vo);
        return "admin/community/fm/fm_write";
    }

    @RequestMapping("/adm/fmInsert")
    public String AmdQnaInsert(Model model, AdmFmVO vo) {
        service.AdmFmInsert(vo);
        return "redirect:/adm/fm";
    }

    //수정 필요
    @RequestMapping("adm/fmAnswerDelete")
    public String AdmFmDelete(Model model, AdmFmVO vo) {
        vo.setCNo(vo.getCNo());
        service.AdmFmAnswerDelete(vo);


        return "redirect:/adm/fm";
    }


    @RequestMapping("/adm/fmSearch")
    @ResponseBody
    public List<AdmFmVO> AdmFmSearch(AdmFmVO vo) {

        return service.AdmFmSearch(vo);
    }
}
