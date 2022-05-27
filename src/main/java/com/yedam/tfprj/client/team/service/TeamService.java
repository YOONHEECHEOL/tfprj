package com.yedam.tfprj.client.team.service;

import com.yedam.tfprj.client.member.service.MemberVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TeamService {

    // 단건조회
    public TeamVO selectTeam(int teamId);
    public int createTeam(TeamVO vo);

    public TeamVO findTeam(TeamVO vo, HttpServletRequest request);

    // 팀 멤버 조회
    public List<MemberVO> selectTeamMembers(int teamId);

    public List<TeamVO> teamAll();

    public List<TeamVO> admSearchTeam(TeamVO vo);
}
