package com.yedam.tfprj.client.member.service;


import com.yedam.tfprj.client.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    // 로그인
    @Override
    public MemberVO selectMember(HttpServletRequest request, MemberVO vo) {

        HttpSession httpSession = request.getSession();

        vo = memberMapper.selectMember(vo);
        if (vo != null) {
            httpSession.setAttribute("member", vo);
            httpSession.setAttribute("memberId", vo.getMemberId());
            httpSession.setAttribute("log", "y");
            httpSession.setAttribute("message", vo.getMemberId() + "님 로그인되었습니다.");

            // 단일 리스트 또는 로그인
            return vo;
        } else
            return null;

    }

    // 로그아웃
    @Override
    public String logoutMember(HttpServletRequest request, MemberVO vo) {
        HttpSession httpSession = request.getSession();

        String result = httpSession.getAttribute("memberId") + "님 로그아웃 되었습니다.";

        httpSession.invalidate();

        return result;
    }

    @Override
    public void logoutMessage(HttpServletRequest request, String message) {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("message", message);

    }


    @Override
    public MemberVO findOne(HttpServletRequest request, MemberVO vo) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) (session.getAttribute("memberId")));
        vo = memberMapper.selectMember(vo);
        return vo;
    }

    @Override //회원가입
    public int insertMember(MemberVO vo) {
        memberMapper.insertMember(vo);
        return '1';
    }

    @Override
    public int updateMember(MemberVO vo) {
        return memberMapper.updateMember(vo);
    }

    @Override
    public int updateMember2(MemberVO vo) {
        return memberMapper.updateMember2(vo);
    }

    @Override
    public GameVO selectGame(MemberVO vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) session.getAttribute("memberId"));
        return memberMapper.selectGame(vo);
    }

    @Override
    public List<MemberVO> searchMember(MemberVO vo) {
        return memberMapper.searchMember(vo);
    }

    @Override
    public List<MemberVO> isTeam(MemberVO vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) session.getAttribute("memberId"));
        List<MemberVO> list = memberMapper.isTeam(vo);
        return list;
    }

    @Override
    public List<MemberVO> selectAll() {
        List<MemberVO> list = memberMapper.selectAll();
        return list;
    }

    @Override
    public int gradeUpdate(MemberVO vo) {
        return memberMapper.gradeUpdate(vo);
    }

    @Override
    public List<MemberVO> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public List<MemberVO> findBlack() {
        return memberMapper.findBlack();
    }

    @Override
    public int blackUpdate(MemberVO vo) {
        return memberMapper.blackUpdate(vo);
    }

    @Override
    public List<MemberVO> teamMember(MemberVO vo) {
        List<MemberVO> list = memberMapper.teamMember(vo);
        return list;
    }

    @Override
    public void reasonUpdate(MemberVO vo) {
        if(vo.getBlacklistYn() == 1){
            vo.setBlacklistReason("기물파손");
        }else{
            vo.setBlacklistReason("불량한 게임 태도");
        }
        memberMapper.reasonUpdate(vo);
    }

    @Override
    public List<MemberVO> admSearchMember(MemberVO vo) {
        System.out.println(vo);
        return memberMapper.admSearchMember(vo);
    }


}
