package com.yedam.tfprj.client.member.service;


import com.yedam.tfprj.admin.reservation.service.MemberGameVO;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService, UserDetailsService {

    @Autowired
    MemberMapper memberMapper;

    // 로그인
    @Override
    public MemberVO selectMember(HttpServletRequest request, MemberVO vo) {

        HttpSession httpSession = request.getSession();

        vo = memberMapper.selectMember(vo);

        if(vo != null)
            return vo;
        else
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

    // 로그아웃 메세지
    @Override
    public void logoutMessage(HttpServletRequest request, String message) {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("message", message);

    }

    // 단건조회
    @Override
    public MemberVO findOne(HttpServletRequest request, MemberVO vo) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) (session.getAttribute("memberId")));
        vo = memberMapper.selectMember(vo);
        return vo;
    }

    @Transactional //회원가입
    public int insertMember(MemberVO vo) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));

        memberMapper.insertMember(vo);
        return '1';
    }

    //회원정보 수정
    @Override
    public int updateMember(MemberVO vo) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return memberMapper.updateMember(vo);
    }

    //회원팀ID 수정
    @Override
    public int updateMember2(MemberVO vo) {
        return memberMapper.updateMember2(vo);
    }

    //게임정보 조회
    @Override
    public List<MemberGameVO> selectGame(MemberVO vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) session.getAttribute("memberId"));
        List<MemberGameVO> list = memberMapper.selectGame(vo);
        return list;
    }

    // 멤버 검색기능
    @Override
    public List<MemberVO> searchMember(MemberVO vo) {
        return memberMapper.searchMember(vo);
    }

    //팀 정보 조회
    @Override
    public List<MemberVO> isTeam(MemberVO vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) session.getAttribute("memberId"));
        List<MemberVO> list = memberMapper.isTeam(vo);
        return list;
    }

    // 전체조회
    @Override
    public List<MemberVO> selectAll() {
        List<MemberVO> list = memberMapper.selectAll();
        return list;
    }

    //회원등급수정
    @Override
    public int gradeUpdate(MemberVO vo) {
        return memberMapper.gradeUpdate(vo);
    }

    //전체조회
    @Override
    public List<MemberVO> findAll() {
        return memberMapper.findAll();
    }

    //블랙리스트 조회
    @Override
    public List<MemberVO> findBlack() {
        return memberMapper.findBlack();
    }

    //블랙리스트 등록,해제
    @Override
    public int blackUpdate(MemberVO vo) {
        return memberMapper.blackUpdate(vo);
    }

    //팀원 조회
    @Override
    public List<MemberVO> teamMember(MemberVO vo) {
        List<MemberVO> list = memberMapper.teamMember(vo);
        return list;
    }

    //블랙리스트 사유 변경
    @Override
    public void reasonUpdate(MemberVO vo) {
        if (vo.getBlacklistYn() == 1) {
            vo.setBlacklistReason("기물파손");
        } else {
            vo.setBlacklistReason("불량한 게임 태도");
        }
        memberMapper.reasonUpdate(vo);
    }

    //관리자 회원 검색 기능
    @Override
    public List<MemberVO> admSearchMember(MemberVO vo) {
        System.out.println(vo);
        return memberMapper.admSearchMember(vo);
    }

    //팀원 방출
    @Override
    public void releaseTeam(MemberVO vo) {
        memberMapper.releaseTeam(vo);
    }


    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        MemberVO vo = new MemberVO();
        vo.setMemberId(memberId);
        vo = memberMapper.selectMember(vo);
        vo.setMemberAuth("ROLE_USER");
        if (vo == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return vo;
    }
}

