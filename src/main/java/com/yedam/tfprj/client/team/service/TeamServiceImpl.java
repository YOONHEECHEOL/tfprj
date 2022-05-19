package com.yedam.tfprj.client.team.service;

import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
