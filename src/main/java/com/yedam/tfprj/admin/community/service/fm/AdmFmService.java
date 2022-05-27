package com.yedam.tfprj.admin.community.service.fm;

import java.util.List;

public interface AdmFmService {
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
