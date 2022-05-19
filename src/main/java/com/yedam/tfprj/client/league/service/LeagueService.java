package com.yedam.tfprj.client.league.service;


public interface LeagueService {

    // league list 출력
    public CliLeagueServiceVO getLeagueList();

    // league detail
    public CliLeagueServiceVO getLeagueDetail(int lno, String memberId);


}
