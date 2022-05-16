package com.yedam.tfprj.client.member.service;


import com.yedam.tfprj.client.common.mapper.MemberVO;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<MemberVO> findAll() {
        return null;
    }

    @Override
    public MemberVO findOne(MemberVO vo) {
        return null;
    }
}
