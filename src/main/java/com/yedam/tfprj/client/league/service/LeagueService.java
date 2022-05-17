package com.yedam.tfprj.client.league.service;


public interface LeagueService {

    // league list 출력
    public LeagueServiceVO getLeagueList();

    // league detail
    public LeagueServiceVO getLeagueDetail(int lno, String memberId);

}
