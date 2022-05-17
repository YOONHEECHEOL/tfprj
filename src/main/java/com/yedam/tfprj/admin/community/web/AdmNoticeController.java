package com.yedam.tfprj.admin.community.web;

import com.yedam.tfprj.admin.community.service.AdmNoticeService;
import com.yedam.tfprj.admin.community.service.AdmNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmNoticeController {

    @Autowired
    AdmNoticeService service;

    @RequestMapping("/admNotice")
    public String AdmNoticeList(Model model, AdmNoticeVO vo) {

        model.addAttribute("admNotice", service.AdmNoticeList(vo));
        return "admin/community/notice/notice";
    }

    @RequestMapping("/noticeWrite")
    public String NoticeWrite(Model model, AdmNoticeVO vo) {
        return "admin/community/notice/noticeWrite";
    }


   /* @ResponseBody
    @PostMapping("/upload/image")
    public Map<String, Object> uploadImage(@RequestParam Map<String, Object> paramMap, MultipartRequest request) throws Exception
    {
        MultipartFile uploadFile = request.getFile("upload");
        String uploadDir = servletContext.getRealPath("/").replace("\\", "/") + "/static/upload/images/";
        String uploadId = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        uploadFile.transferTo(new File(uploadDir + uploadId));
        paramMap.put("url", "/static/upload/images/" + uploadId);
        return paramMap;
    }*/


}

