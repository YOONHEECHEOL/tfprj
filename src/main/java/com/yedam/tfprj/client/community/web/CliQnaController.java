package com.yedam.tfprj.client.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.community.service.qna.CliQnaService;
import com.yedam.tfprj.client.community.service.qna.CliQnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

@Controller
public class CliQnaController {

    @Autowired
    CliQnaService service;

    @RequestMapping("/cli/qna")
    public String CliQnaList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, CliQnaVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CliQnaVO> pageInfo = new PageInfo<CliQnaVO>(service.CliQnaList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "client/community/qna/qna";
    }

    @RequestMapping("/cli/qnaDetail")
    public String qnaDetail(Model model, CliQnaVO vo) {
        vo.setQNo(vo.getQNo());
        model.addAttribute("qna", service.CliQnaSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.CliReplyList(vo)); // 코맨트 리스트
        return "client/community/qna/qna_detail";
    }

    @RequestMapping("/cli/qnaAnswerInsert")
    public String CliAnswerInsert(Model model, CliQnaVO vo, HttpSession session) {
        String writer = (String) session.getAttribute("memberId");
        vo.setWriter(writer);
        service.CliQnaAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/cli/qnaDetail?qNo=" + vo.getQNo();
    }

    @RequestMapping(value = "/cli/qnaDelete", method = RequestMethod.GET)
    public String qnaDelete(CliQnaVO vo) {
        service.CliQnaDelete(vo);
        vo.setQNo(vo.getQNo());
        return "redirect:/cli/qna";
    }

    @RequestMapping(value = "/cli/qnaUpdate", method = RequestMethod.POST)
    public String qnaUpdate(Model model, CliQnaVO vo) {
        model.addAttribute("qna", service.CliQnaSelect(vo));

        return "client/community/qna/qna_update";
    }

    @RequestMapping("/cli/qnaUpdateForm")
    public String CliQnaUpdate(Model model, CliQnaVO vo) {
        service.CliQnaUpdate(vo);
        return "redirect:/cli/qna";
    }


    @RequestMapping("/cli/qnaWrite")
    public String CliQnaWrite(Model model, CliQnaVO vo, HttpSession session) {
        String writer = (String) session.getAttribute("memberId");
        model.addAttribute("qna", vo);
        return "/client/community/qna/qnaWrite";
    }


    @RequestMapping("/cli/qnaInsert")
    public String CliQnaInsert(Model model, CliQnaVO vo) {
        service.CliQnaInsert(vo);
        return "redirect:/cli/qna";
    }

    @RequestMapping("cli/qnaAnswerDelete")
    public String CliQnaDelete(Model model, CliQnaVO vo) {
        service.CliQnaAnswerDelete(vo);

        return "redirect:/cli/qna";
    }

    @RequestMapping("/cli/imageUpload")
    public void imageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload)
        //MultipartFile 타입은 ckedit에서 upload란 이름으로 저장하게 된다
            throws Exception {

        // 한글깨짐을 방지하기위해 문자셋 설정
        response.setCharacterEncoding("utf-8");

        // 마찬가지로 파라미터로 전달되는 response 객체의 한글 설정
        response.setContentType("text/html; charset=utf-8");

        // 업로드한 파일 이름
        String fileName = upload.getOriginalFilename();

        // 파일을 바이트 배열로 변환
        byte[] bytes = upload.getBytes();

        // 이미지를 업로드할 디렉토리(배포 디렉토리로 설정)
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploadImg");

        OutputStream out = new FileOutputStream(new File(uploadPath + "/" + fileName));

        // 서버로 업로드
        // write메소드의 매개값으로 파일의 총 바이트를 매개값으로 준다.
        // 지정된 바이트를 출력 스트립에 쓴다 (출력하기 위해서)
        out.write(bytes);

        // 클라이언트에 결과 표시
        String callback = request.getParameter("CKEditorFuncNum");

        // 서버=>클라이언트로 텍스트 전송(자바스크립트 실행)
        PrintWriter printWriter = response.getWriter();
        String fileUrl = request.getContextPath() + "/uploadImg/" + fileName;
        printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
                + "','이미지가 업로드되었습니다.')" + "</script>");
        printWriter.flush();

    }

}
