package com.yedam.tfprj.client.league.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.client.league.mapper.CliLeagueMapper;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CliLeagueServiceImpl implements LeagueService{

    @Autowired
    CliLeagueMapper cliLeagueMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    TeamMapper teamMapper;

    @Override
    public CliLeagueServiceVO getLeagueList() {
        LocalDate now = LocalDate.now();
        List<LeagueVO> leagueList = cliLeagueMapper.getLeagueList();
        CliLeagueServiceVO leagueCurrentPassed = new CliLeagueServiceVO();

        // 현재 진행 중인 리스트 목록
        List<LeagueVO> currentLeagueList = new ArrayList<>();
        // 지난 리그 리스트 목록
        List<LeagueVO> passedLeagueList = new ArrayList<>();

        // 분할
        leagueList.forEach(league -> {
            if( now.isBefore( toLocalDateInstant( league.getEndDate() ) ) ) {
                // 현재 진행 중
                currentLeagueList.add(league);
            } else {
                passedLeagueList.add(league);
            }
        });

        // 현재 진행 중인 리그
        leagueCurrentPassed.setCurrentList(currentLeagueList);
        // 지난 리그
        leagueCurrentPassed.setPassedList(passedLeagueList);

        return leagueCurrentPassed;
    }

    @Override
    public CliLeagueServiceVO getLeagueDetail(int lno, String memberId) {

        CliLeagueServiceVO leagueServiceVO = new CliLeagueServiceVO();

        // 멤버 조회
        leagueServiceVO.loginedMember.setMemberId(memberId);
        leagueServiceVO.loginedMember = memberMapper.selectMember(leagueServiceVO.loginedMember);

        // 리그 조회
        leagueServiceVO.leagueVO = cliLeagueMapper.getLeagueDetail(lno);

        // 팀 조회
//        final String uri = "http://localhost:18000/cli/getTeam?teamId=";
//
//        System.out.println("leagueServiceVO.loginedMember = " + leagueServiceVO.loginedMember);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<TeamVO> result = restTemplate.exchange(uri + leagueServiceVO.loginedMember.getTeamId(), HttpMethod.GET, null, TeamVO.class);

        // team 입력
//        leagueServiceVO.teamVO = result.getBody();
        leagueServiceVO.teamVO = teamMapper.selectTeam(leagueServiceVO.loginedMember.getTeamId());

        leagueServiceVO.teamMembers = teamMapper.selectTeamMembers(leagueServiceVO.loginedMember.getTeamId());

//        System.out.println("result = " + result);


        if(leagueServiceVO.loginedMember != null)
            return leagueServiceVO;
        else
            return null;

    }

    @Override
    public void insertLeagueApply(CliLeagueServiceVO cliLeagueServiceVO, List<Map<String, Object>> getLeagueParticipatedMember) {

        final String[] dd = {""};
        getLeagueParticipatedMember.forEach(res -> {
            String returnVal = res.get("value").toString();
            dd[0] += returnVal;
        });
        for(int i=0; i<getLeagueParticipatedMember.size(); i++) {
            dd[i] += getLeagueParticipatedMember.get(i).get("value");
        }


        getLeagueParticipatedMember.forEach(res -> {
            LeagueApplyVO leagueApplyVO = new LeagueApplyVO();

            leagueApplyVO.setLeagueId(cliLeagueServiceVO.getLeagueVO().getLeagueId());
            leagueApplyVO.setIsApprove("501");
            leagueApplyVO.setEntryFee(cliLeagueServiceVO.getLeagueVO().getEntryFee());
            leagueApplyVO.setMemberId(dd[0]);
            leagueApplyVO.setTeamMember(getLeagueParticipatedMember.toString());

            System.out.println("======================leagueApplyVO = " + leagueApplyVO);

            cliLeagueMapper.submitLeagueApply(leagueApplyVO);
        });
    }

    public String convertWithStream(Map<String, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    // league 선발된 멤버 반환
    public List<Map<String, Object>> getLeagueParticipatedMember(String formVal) {

        ObjectMapper obejectMapper = new ObjectMapper();

        List<Map<String, Object>> returnVal = new ArrayList<>();
        try {
            returnVal = obejectMapper.readValue(formVal, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 앞에 두개 인자 삭제
        returnVal.remove(0);
        returnVal.remove(0);

        return returnVal;
    }

    // localDate 크기 비교를 위한 변경
    public LocalDate toLocalDateInstant(Date dateToConvert) {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String returnDate = dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().format(formatter);

        return LocalDate.parse(returnDate);
    }


}
