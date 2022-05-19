package com.yedam.tfprj.client.team.service;

public interface TeamService {

    // 단건조회
    public TeamVO selectTeam(int teamId);
    public int createTeam(TeamVO vo);

    public TeamVO findTeam(TeamVO vo);
}
