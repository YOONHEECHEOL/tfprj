package com.yedam.tfprj.client.member.service;

import com.yedam.tfprj.client.common.mapper.MemberVO;

import java.util.List;

public interface MemberService {
    public List<MemberVO> findAll();
    //멤버 단건 조회
    public MemberVO findOne(MemberVO vo);

}
