package com.yedam.tfprj.client.member.mapper;



import com.github.pagehelper.PageHelper;
import com.yedam.tfprj.client.member.service.GameVO;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.lang.reflect.Member;
import java.util.List;

@Mapper
public interface MemberMapper {
    //멤버 전체 조회
    public List<MemberVO> selectAll();
    
    //로그인 + 단건 조회 (password 미 입력 시 단건조회)
    MemberVO selectMember(MemberVO vo);

    // 회원가입
    int insertMember(MemberVO vo);

    //멤버 정보 수정
    int updateMember(MemberVO vo);

    int updateMember2(MemberVO vo);
    //멤버 스코어 조회
    GameVO selectGame(MemberVO vo);
    
    //멤버명 검색
    List<MemberVO> searchMember(MemberVO vo);

    //팀에 속해 있는 멤버 조회
    List<MemberVO> isTeam(MemberVO vo);

    //관리자 - 회원등급수정
    int gradeUpdate(MemberVO vo);
    //전체리스트
    List<MemberVO> findAll();
    //블랙리스트 조회
    List<MemberVO> findBlack();
    //블랙리스트 상태변경
    int blackUpdate(MemberVO vo);
    //팀원조회
    List<MemberVO> teamMember(MemberVO vo);
}
