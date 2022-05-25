package com.yedam.tfprj.client.league.service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface LeagueService {

    // 전체 리스트 조회(현재/지난 리그 분류되어 return)
    public CliLeagueServiceVO getLeagueList(HttpServletRequest request);

    // 리그 상세조회
    public CliLeagueServiceVO getLeagueDetail(int lno, String memberId);

    // league 선발된 멤버 반환
    public List<Map<String, Object>> getLeagueParticipatedMember(String formVal);

    // 리그 신청 처리
    public void insertLeagueApply(CliLeagueServiceVO cliLeagueServiceVO, List<Map<String, Object>> getLeagueParticipatedMember);

    // league_apply table 에 member_id 가 있으면 true 를 반환
    public List<LeagueApplyVO> checkLeagueApply(LeagueApplyVO leagueApplyVO);

    // My page league 조회
    public CliLeagueServiceVO getMyLeague(HttpServletRequest request);

}
