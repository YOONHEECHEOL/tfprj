package com.yedam.tfprj.client.member.service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    public List<MemberVO> findAll();
    //멤버 단건 조회
    public MemberVO findOne(MemberVO vo);

    MemberVO selectMember(HttpServletRequest request, MemberVO vo); // 로그인 0516
    int insertMember(MemberVO vo); // 회원가입 0513

    int updateMember(MemberVO vo);

    GameVO selectGame(MemberVO vo);

}
