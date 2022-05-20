package com.yedam.tfprj.admin.community.service.qna;


import java.util.List;

public interface AdmQnaService {

    public List<AdmQnaVO> AdmQnaList(AdmQnaVO vo);

    AdmQnaVO  AdmQnaSelect(AdmQnaVO vo);

    public void AdmQnaDelete(AdmQnaVO vo);

    public void AdmQnaUpdate(AdmQnaVO vo);

    public void AdmQnaInsert(AdmQnaVO vo);

    public List<AdmQnaVO> AdmReplyList(AdmQnaVO vo);

    public void AdmQnaAnswerInsert(AdmQnaVO vo);
}