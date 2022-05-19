package com.yedam.tfprj.admin.community.service.qna;

import com.yedam.tfprj.admin.community.mapper.AdmQnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmQnaServiceImpl implements AdmQnaService {

    @Autowired
    AdmQnaMapper mapp;

    @Override
    public List<AdmQnaVO> AdmQnaList(AdmQnaVO vo){
        return mapp.AdmQnaList(vo);
    }


}
