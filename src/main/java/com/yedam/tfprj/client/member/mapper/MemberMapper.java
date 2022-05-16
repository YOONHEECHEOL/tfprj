package com.yedam.tfprj.client.member.mapper;


import com.yedam.tfprj.client.member.service.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //멤버 전체 조회
    public List<MemberVO> findAll();
    //멤버 단건 조회
    public MemberVO findOne(MemberVO vo);
    
    
    //로그인
    MemberVO selectMember(MemberVO vo); //로그인 0516
    int insertClient(MemberVO vo);  //회원가입 0513
 
}
