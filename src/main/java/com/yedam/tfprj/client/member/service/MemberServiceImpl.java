package com.yedam.tfprj.client.member.service;


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

    @Override //회원가입
    public int insertClient(MemberVO vo) {
        return memberMapper.insertClient(vo);
    }

    @Override //로그인
    public MemberVO selectMember(MemberVO vo) {
        // 단일 리스트 또는 로그인
        return memberMapper.selectMember(vo);
    }
}
