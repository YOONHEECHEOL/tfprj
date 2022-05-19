package com.yedam.tfprj.admin.league.service;

public interface LeagueService {

    // league List 출력
    public AdmLeagueServiceVO getLeagueList();

    // league detail
    public AdmLeagueServiceVO getLeagueDetail(int lno);

}
