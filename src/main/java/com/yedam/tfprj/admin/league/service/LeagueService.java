package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.client.league.service.LeagueVO;

public interface LeagueService {

    // league List 출력
    public AdmLeagueServiceVO getLeagueList();

    // league detail
    public AdmLeagueServiceVO getLeagueDetail(int lno);

    // league 생성
    public void insertLeague(LeagueVO leagueVO);

    //getLeagueApply
    public AdmLeagueServiceVO getLeagueApply(int leagueId);

    // getLeagueApplyTeam
    public AdmLeagueServiceVO getLeagueApplyTeam(int teamId, int leagueId);

    // setLeagueApplyTeamStatus
    public void setLeagueApplyTeamStatus(int teamId, int leagueId);

}
