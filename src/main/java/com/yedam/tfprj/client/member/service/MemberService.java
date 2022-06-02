package com.yedam.tfprj.client.member.service;


import com.yedam.tfprj.admin.reservation.service.MemberGameVO;
import com.yedam.tfprj.client.game.service.GameVO;
import com.yedam.tfprj.client.message.service.MessageVO;

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
    public void logoutMessage(HttpServletRequest request, String message);

    // 회원가입
    int insertMember(MemberVO vo);

    //회원정보수정
    int updateMember(MemberVO vo);

    //팀아이디수정
    int updateMember2(MemberVO vo);

    //기록 조회
    List<MemberGameVO> selectGame(MemberVO vo, HttpServletRequest request);

    //멤버 검색
    List<MemberVO> searchMember(MemberVO vo);

    //팀에 속해 있는 멤버 조회
    List<MemberVO> isTeam(MemberVO vo, HttpServletRequest request);

    //멤버 전체 조회
    public List<MemberVO> selectAll();

    //관리자 - 회원등급수정
    int gradeUpdate(MemberVO vo);

    //전체 조회
    public List<MemberVO> findAll();

    //블랙리스트 조회
    public List<MemberVO> findBlack();

    //블랙리스트 등록,해제 처리
    public int blackUpdate(MemberVO vo);

    //팀원 조회
    public List<MemberVO> teamMember(MemberVO vo);

    //블랙리스트 사유 변경
    public void reasonUpdate(MemberVO vo);

    //관리자페이지 리스트 조회시 memberId 검색기능
    public List<MemberVO> admSearchMember(MemberVO vo);

    //팀원 방출
    void releaseTeam(MemberVO vo);
}
