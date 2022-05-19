package com.yedam.tfprj.client.team.service;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public TeamVO findTeam(TeamVO vo) {
        return teamMapper.findTeam(vo);
    }

    // 팀 멤버 조회
    @Override
    public List<MemberVO> selectTeamMembers(int teamId) {
        return teamMapper.selectTeamMembers(teamId);
    }
}
