package com.yedam.tfprj.client.league.service;


import java.util.List;
import java.util.Map;

public interface LeagueService {

    // league list 출력
    public CliLeagueServiceVO getLeagueList();

    // league detail
    public CliLeagueServiceVO getLeagueDetail(int lno, String memberId);

    public List<Map<String, Object>> getLeagueParticipatedMember(String formVal);

    public void insertLeagueApply(CliLeagueServiceVO cliLeagueServiceVO, List<Map<String, Object>> getLeagueParticipatedMember);

}
