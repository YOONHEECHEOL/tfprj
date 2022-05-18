package com.yedam.tfprj.admin.community.service;

import com.yedam.tfprj.admin.community.mapper.AdmNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmNoticeServiceImpl implements AdmNoticeService {

    @Autowired
    AdmNoticeMapper map;

    @Override
    public List<AdmNoticeVO> AdmNoticeList(AdmNoticeVO vo) {
        return map.AdmNoticeList(vo);
    }
    @Override
    public AdmNoticeVO AdmNoticeSelect(AdmNoticeVO vo) {
        return map.AdmNoticeSelect(vo);
    }
    @Override
    public int noticeDelete(AdmNoticeVO vo) {
        return map.noticeDelete(vo);
    }

}
