package com.yedam.tfprj.client.common.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberVO selectMember(MemberVO vo); //로그인 0516
    int insertClient(MemberVO vo);  //회원가입 0513

}
