package com.yedam.tfprj.client.community.service.notice;

import com.yedam.tfprj.client.community.mapper.CliNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliNoticeServiceImpl implements CliNoticeService{
    @Autowired
    CliNoticeMapper map;

    @Override
    public List<CliNoticeVO> CliNoticeList(CliNoticeVO vo) {
        return map.CliNoticeList(vo);
    }

    @Override
    public CliNoticeVO CliNoticeSelect(CliNoticeVO vo) {
        return map.CliNoticeSelect(vo);
    }
    @Override
    public void CliNoticeViewCount(int nNo){
        map.CliNoticeViewCount(nNo);
    }

}
