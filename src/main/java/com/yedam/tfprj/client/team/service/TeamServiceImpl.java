package com.yedam.tfprj.client.team.service;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public TeamVO selectTeam(int teamId) {
        return teamMapper.selectTeam(teamId);
    }

    @Override
    public int createTeam(TeamVO vo) {
        return teamMapper.createTeam(vo);
    }

    @Override
    public TeamVO findTeam(TeamVO vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setLeader((String)session.getAttribute("memberId"));
        vo = teamMapper.findTeam(vo);
        return vo;
    }

    // 팀 멤버 조회
    @Override
    public List<MemberVO> selectTeamMembers(int teamId) {
        return teamMapper.selectTeamMembers(teamId);
    }

    @Override
    public List<TeamVO> teamAll() {
        return teamMapper.teamAll();
    }

    @Override
    public List<TeamVO> admSearchTeam(TeamVO vo) {
        return teamMapper.admSearchTeam(vo);
    }


}
