package com.yedam.tfprj.client.member.service;






import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    //멤버 단건 조회
    public MemberVO findOne(HttpServletRequest request, MemberVO vo);

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
    GameVO selectGame(MemberVO vo, HttpServletRequest request);
    
    //멤버 검색
    List<MemberVO> searchMember(MemberVO vo);

    //팀에 속해 있는 멤버 조회
    List<MemberVO> isTeam(MemberVO vo, HttpServletRequest request);

    //멤버 전체 조회
    public List<MemberVO> selectAll();

    //관리자 - 회원등급수정
    int gradeUpdate(MemberVO vo);

    public List<MemberVO> findAll();

    public List<MemberVO> findBlack();



}
