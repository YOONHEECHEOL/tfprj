package com.yedam.tfprj.admin.community.service.faq;

import com.yedam.tfprj.admin.community.mapper.AdmFaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmFaqServiceImpl implements AdmFaqService {
    @Autowired
    AdmFaqMapper map;

    @Override
    public List<AdmFaqVO> AdmFaqList(AdmFaqVO vo){
        return map.AdmFaqList(vo);
    }

    @Override
    public List<AdmFaqVO> AdmFaqTitleList(AdmFaqVO vo){
        return map.AdmFaqTitleList(vo);
    }

    @Override
    public void AdmFaqInsert(AdmFaqVO vo){
        map.AdmFaqInsert(vo);
    }

    @Override
    public void AdmFaqTitleInsert(AdmFaqVO vo){
        map.AdmFaqTitleInsert(vo);
    }
}
