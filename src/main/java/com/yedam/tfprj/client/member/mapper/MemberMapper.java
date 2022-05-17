package com.yedam.tfprj.client.member.mapper;


import com.yedam.tfprj.client.member.service.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //멤버 전체 조회
    public List<MemberVO> selectAll();
    
    //로그인 + 단건 조회 (password 미 입력 시 단건조회)
    MemberVO selectMember(MemberVO vo);

    // 회원가입
    int insertMember(MemberVO vo);
 
}
