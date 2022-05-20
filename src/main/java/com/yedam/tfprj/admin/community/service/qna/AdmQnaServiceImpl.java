package com.yedam.tfprj.admin.community.service.qna;

import com.yedam.tfprj.admin.community.mapper.AdmQnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmQnaServiceImpl implements AdmQnaService {

    @Autowired
    AdmQnaMapper map;

    @Override
    public List<AdmQnaVO> AdmQnaList(AdmQnaVO vo){
        return map.AdmQnaList(vo);
    }

    @Override
    public AdmQnaVO AdmQnaSelect(AdmQnaVO vo){
        return map.AdmQnaSelect(vo);
    }

    @Override
    public void AdmQnaDelete(AdmQnaVO vo){
        map.AdmQnaDelete(vo);
    }

    @Override
    public void AdmQnaUpdate(AdmQnaVO vo){
        map.AdmQnaUpdate(vo);
    }

    @Override
    public void AmdQnaInsert(AdmQnaVO vo){
//        map.AmdQnaInsert(vo);
    }
}
