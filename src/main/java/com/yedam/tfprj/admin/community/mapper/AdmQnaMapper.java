package com.yedam.tfprj.admin.community.mapper;


import com.yedam.tfprj.admin.community.service.qna.AdmQnaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmQnaMapper {
    public List<AdmQnaVO> AdmQnaList(AdmQnaVO vo);

    AdmQnaVO AdmQnaSelect(AdmQnaVO vo);

    public void AdmQnaDelete(AdmQnaVO vo);

    public void AdmQnaUpdate(AdmQnaVO vo);

    public void AdmQnaInsert(AdmQnaVO vo);

    public List<AdmQnaVO> AdmReplyList(AdmQnaVO vo);

    public void AdmQnaAnswerInsert(AdmQnaVO vo);
    
    public void AdmQnaAnswerDelete(AdmQnaVO vo);
}