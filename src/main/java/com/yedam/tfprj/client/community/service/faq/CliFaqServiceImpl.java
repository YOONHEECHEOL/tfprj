package com.yedam.tfprj.client.community.service.faq;

import com.yedam.tfprj.client.community.mapper.CliFaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliFaqServiceImpl implements CliFaqService {
    @Autowired
    CliFaqMapper map;

    @Override
    public List<CliFaqVO> CliFaqList(CliFaqVO vo){
        System.out.println("=-========================map.CliFaqList(vo) = " + map.CliFaqList(vo));
        return map.CliFaqList(vo);
    }
}
