package com.yedam.tfprj.admin.community.mapper;

import com.yedam.tfprj.admin.community.service.fm.AdmFmVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmFmMapper {
    public List<AdmFmVO> AdmFmList(AdmFmVO vo);

    AdmFmVO AdmFmSelect(AdmFmVO vo);

    public void AdmFmDelete(AdmFmVO vo);

    public void AdmFmUpdate(AdmFmVO vo);

    public void AdmFmInsert(AdmFmVO vo);

    public List<AdmFmVO> AdmReplyList(AdmFmVO vo);

    public void AdmFmAnswerInsert(AdmFmVO vo);

    public void AdmFmAnswerDelete(AdmFmVO vo);

    public void AdmFmViewCount(int fNo);

    List<AdmFmVO> AdmFmSearch(AdmFmVO vo);

}
