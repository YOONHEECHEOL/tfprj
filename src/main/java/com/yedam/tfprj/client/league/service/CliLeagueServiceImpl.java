package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.league.mapper.CliLeagueMapper;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

//        System.out.println("result = " + result);

        if(leagueServiceVO.loginedMember != null)
            return leagueServiceVO;
        else
            return null;

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
