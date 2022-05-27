package com.yedam.tfprj.admin.community.service.notice;

import java.util.List;
public interface AdmNoticeService {
    public List<AdmNoticeVO> AdmNoticeList(AdmNoticeVO vo);

    AdmNoticeVO AdmNoticeSelect(AdmNoticeVO vo);
    public void AdmNoticeDelete(AdmNoticeVO vo);
    public void AdmNoticeUpdate(AdmNoticeVO vo);
    public void AdmNoticeInsert(AdmNoticeVO vo);
    public void AdmNoticeViewCount(int nNo);

}