package com.yedam.tfprj.client.common.serviceImpl;

import com.yedam.tfprj.client.common.mapper.MemberMapper;
import com.yedam.tfprj.client.common.mapper.MemberService;
import com.yedam.tfprj.client.common.mapper.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper map;

    @Override //회원가입
    public int insertClient(MemberVO vo) {
        return map.insertClient(vo);
    }

    @Override //로그인
    public MemberVO selectMember(MemberVO vo) {
        // 단일 리스트 또는 로그인
        return map.selectMember(vo);
    }
}
