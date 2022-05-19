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
    
    //회원정보수정
    int updateMember(MemberVO vo);
    
    //팀아이디수정
    int updateMember2(MemberVO vo);
    
    //기록 조회
    GameVO selectGame(MemberVO vo);
    
    //멤버 검색
    List<MemberVO> searchMember(MemberVO vo);



}
