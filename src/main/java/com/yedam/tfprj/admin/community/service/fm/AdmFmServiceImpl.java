package com.yedam.tfprj.admin.community.service.fm;

import com.yedam.tfprj.admin.community.mapper.AdmFmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmFmServiceImpl implements AdmFmService {
    @Autowired
    AdmFmMapper map;

    @Override
    public List<AdmFmVO> AdmFmList(AdmFmVO vo){
        return map.AdmFmList(vo);
    }

    @Override
    public AdmFmVO AdmFmSelect(AdmFmVO vo){
        return map.AdmFmSelect(vo);
    }

    @Override
    public void AdmFmDelete(AdmFmVO vo){
        map.AdmFmDelete(vo);
    }

    @Override
    public void AdmFmUpdate(AdmFmVO vo){
        map.AdmFmUpdate(vo);
    }

    @Override
    public void AdmFmInsert(AdmFmVO vo){
        map.AdmFmInsert(vo);
    }

    @Override
    public List<AdmFmVO> AdmReplyList(AdmFmVO vo){
        return map.AdmReplyList(vo);
    }

    @Override
    public void AdmFmAnswerInsert(AdmFmVO vo){
        map.AdmFmAnswerInsert(vo);
    }

    @Override
    public void AdmFmAnswerDelete(AdmFmVO vo){
        map.AdmFmAnswerDelete(vo);
    }

    @Override
    public void AdmFmViewCount(int fNo){
        map.AdmFmViewCount(fNo);
    }

    @Override
    public List<AdmFmVO> AdmFmSearch(AdmFmVO vo) {
        return map.AdmFmSearch(vo);
    }

}
