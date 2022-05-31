package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.client.league.service.LeagueVO;

import java.util.List;
import java.util.Map;

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

    // league_status table 에서 현재 league 진행 상황 정보를 받아오기
    public AdmLeagueServiceVO getLeagueStatusTable(int leagueId);

    // league_status table 에 승인된 팀 목록 입력하기
    public void insertLeagueStatus(List<Map<String, String>> param);

}
