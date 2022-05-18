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

    @RequestMapping("/admNotice") //리스트
    public String AdmNoticeList(Model model, AdmNoticeVO vo) {

        model.addAttribute("admNotice", service.AdmNoticeList(vo));
        return "admin/community/notice/notice";
    }

    @RequestMapping("/noticeDetail")
    public String NoticeDetail(Model model, AdmNoticeVO vo){
        vo.setNNo(vo.getNNo());
        System.out.println(vo.getNNo());
        model.addAttribute("notice", service.AdmNoticeSelect(vo));

        return "admin/community/notice/notice_detail";
    }

    @RequestMapping("/noticeDelete")
    public String noticeDelete(Model model, AdmNoticeVO vo){

        service.noticeDelete(vo);

        return "redirect:/admNotice";
    }



    @RequestMapping("/noticeWrite")
    public String NoticeWrite(Model model, AdmNoticeVO vo) {
        return "admin/community/notice/noticeWrite";
    }


    /*@ResponseBody
    @RequestMapping(value = "/ck/fileupload", method = {RequestMethod.POST, RequestMethod.GET})
    public String fileUpload(Model model,
                             @RequestParam(value="upload", required = false) MultipartFile fileload,
                             HttpServletRequest req) {

        //서버에 파일을 저장할 때에는 파일명을 시간값으로 변경
        //DB에 저장할 때에는 원본 파일명과 시간값을 모두 저장
        //filename 취득
        String filename = fileload.getOriginalFilename();

        //upload 경로 설정(tomcat realpath)
        String fuploadPath = req.getServletContext().getRealPath("/upload");

        //폴더 경로 설정
        //String newfilename = FUpUtil.name(filename);

        //업로드 수행
        File file = new File(fuploadPath + "/" + filename);


        try {
            //실제 파일이 업로드 되는 부분
            FileUtils.writeByteArrayToFile(file, fileload.getBytes() );
            return "{ \"uploaded\" : true, \"url\" : \"/upload/" + filename + "\" }";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return "{ \"uploaded\" : false, \"error\": { \"message\": \"업로드 중 에러가 발생했습니다. 다시 시도해 주세요.\" } }";
        }
    }*/


}

