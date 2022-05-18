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

    @Override
    public List<MemberVO> findAll() {
        return null;
    }

    @Override
    public MemberVO findOne(MemberVO vo) {
        return null;
    }

    @Override //회원가입
    public int insertMember(MemberVO vo) {
        memberMapper.insertMember(vo);
        return '1';
    }

    @Override
    public int updateMember(MemberVO vo) {
        memberMapper.updateMember(vo);
        return 0;
    }

    @Override
    public GameVO selectGame(MemberVO vo) {
        return null;
    }

    @Override //로그인
    public MemberVO selectMember(HttpServletRequest request, MemberVO vo) {

        HttpSession httpSession = request.getSession();

        vo = memberMapper.selectMember(vo);
        if(vo != null) {
            httpSession.setAttribute("member", vo);
            httpSession.setAttribute("memberId", vo.getMemberId());

            // 단일 리스트 또는 로그인
            return vo;
        } else
            return null;

    }
}
