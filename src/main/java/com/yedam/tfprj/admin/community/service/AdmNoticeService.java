package com.yedam.tfprj.admin.community.service;

import java.util.List;
public interface AdmNoticeService {
    public List<AdmNoticeVO> AdmNoticeList(AdmNoticeVO vo);

    AdmNoticeVO AdmNoticeSelect(AdmNoticeVO vo);

    int noticeDelete(AdmNoticeVO vo);
}