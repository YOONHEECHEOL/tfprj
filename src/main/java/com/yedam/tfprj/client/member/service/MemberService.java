package com.yedam.tfprj.client.member.service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    public List<MemberVO> findAll();
    //멤버 단건 조회
    public MemberVO findOne(MemberVO vo);

    // login
    MemberVO selectMember(HttpServletRequest request, MemberVO vo);

    // logout
    public String logoutMember(HttpServletRequest request, MemberVO vo);

    // logout message 생성
    public void logoutMessage(HttpServletRequest request ,String message);

    // 회원가입
    int insertMember(MemberVO vo);

    int updateMember(MemberVO vo);

    GameVO selectGame(MemberVO vo);



}
