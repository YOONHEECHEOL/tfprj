package com.yedam.tfprj.admin.community.service.faq;

import java.util.List;

public interface AdmFaqService {
    public List<AdmFaqVO>   AdmFaqList(AdmFaqVO vo);
    public List<AdmFaqVO>   AdmFaqTitleList(AdmFaqVO vo);
    public void             AdmFaqInsert(AdmFaqVO vo);
    public void             AdmFaqTitleInsert(AdmFaqVO vo);
}
