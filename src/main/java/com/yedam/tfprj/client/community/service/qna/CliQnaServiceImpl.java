package com.yedam.tfprj.client.community.service.qna;

import com.yedam.tfprj.client.community.mapper.CliQnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliQnaServiceImpl implements CliQnaService{
    @Autowired
    CliQnaMapper map;

    @Override
    public List<CliQnaVO> CliQnaList(CliQnaVO vo){
        return map.CliQnaList(vo);
    }

    @Override
    public CliQnaVO CliQnaSelect(CliQnaVO vo){
        return map.CliQnaSelect(vo);
    }

    @Override
    public void CliQnaDelete(CliQnaVO vo){
        map.CliQnaDelete(vo);
    }

    @Override
    public void CliQnaUpdate(CliQnaVO vo){
        map.CliQnaUpdate(vo);
    }

    @Override
    public void CliQnaInsert(CliQnaVO vo){
        map.CliQnaInsert(vo);
    }

    @Override
    public List<CliQnaVO> CliReplyList(CliQnaVO vo){
        return map.CliReplyList(vo);
    }

    @Override
    public void CliQnaAnswerInsert(CliQnaVO vo){
        map.CliQnaAnswerInsert(vo);
    }

    @Override
    public void CliQnaAnswerDelete(CliQnaVO vo){
        map.CliQnaAnswerDelete(vo);
    }
    @Override
    public void CliQnaViewCount(int qNo){
        map.CliQnaViewCount(qNo);
    }

}
