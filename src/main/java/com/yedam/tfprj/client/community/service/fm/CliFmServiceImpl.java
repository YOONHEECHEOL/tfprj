package com.yedam.tfprj.client.community.service.fm;

import com.yedam.tfprj.client.community.mapper.CliFmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliFmServiceImpl implements CliFmService{
    @Autowired
    CliFmMapper map;

    @Override
    public List<CliFmVO> CliFmList(CliFmVO vo){
        return map.CliFmList(vo);
    }

    @Override
    public CliFmVO CliFmSelect(CliFmVO vo){
        return map.CliFmSelect(vo);
    }

    @Override
    public void CliFmDelete(CliFmVO vo){
        map.CliFmDelete(vo);
    }

    @Override
    public void CliFmUpdate(CliFmVO vo){
        map.CliFmUpdate(vo);
    }

    @Override
    public void CliFmInsert(CliFmVO vo){
        map.CliFmInsert(vo);
    }

    @Override
    public List<CliFmVO> CliReplyList(CliFmVO vo){
        return map.CliReplyList(vo);
    }

    @Override
    public void CliFmAnswerInsert(CliFmVO vo){
        map.CliFmAnswerInsert(vo);
    }

    @Override
    public void CliFmAnswerDelete(CliFmVO vo){
        map.CliFmAnswerDelete(vo);
    }
}
