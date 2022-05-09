package com.yedam.tfprj.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public MemberVO getMember(MemberVO memberVO);
    public List<MemberVO> getMemberList();

}
