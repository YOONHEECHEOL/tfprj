package com.yedam.tfprj.client.league.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.client.league.mapper.CliLeagueMapper;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    // 전체 리스트 조회(현재/지난 리그 분류되어 return)
    @Override
    public CliLeagueServiceVO getLeagueList(HttpServletRequest request) {
        LocalDate now = LocalDate.now();
        List<LeagueVO> leagueList = cliLeagueMapper.getLeagueList();
        CliLeagueServiceVO cliLeagueServiceVO = new CliLeagueServiceVO();

        // 현재 진행 중인 리스트 목록
        List<LeagueVO> currentLeagueList = new ArrayList<>();
        // 지난 리그 리스트 목록
        List<LeagueVO> passedLeagueList = new ArrayList<>();

        // 분할
        leagueList.forEach(league -> {
            if( Integer.parseInt(league.getLeagueStatusCd()) != 502 && Integer.parseInt(league.getLeagueStatusCd()) != 503 ) {
                // 현재 진행 중
                LeagueApplyVO leagueApplyVO = new LeagueApplyVO();
                if(request.getSession().getAttribute("memberId") != null) {
                    leagueApplyVO.setLeagueId(league.getLeagueId());
                    leagueApplyVO.setMemberId(request.getSession().getAttribute("memberId").toString());

                    // 리그에 참가했는지 검증
                    if(cliLeagueMapper.isLeagueApply(leagueApplyVO).size() > 0) {
                        // 참가했음
                        league.setIsApply("y");
                    } else {
                        // 참가하지 않음
                        league.setIsApply("n");
                    };

                    // 출력 리스트에 추가
//                    currentLeagueList.add(league);
                currentLeagueList.add(league);
                }


            } else {
                passedLeagueList.add(league);
            }
        });

        // 현재 진행 중인 리그
        cliLeagueServiceVO.setCurrentList(currentLeagueList);
        // 지난 리그
        cliLeagueServiceVO.setPassedList(passedLeagueList);

        return cliLeagueServiceVO;
    }

    // 나의 리그 조회


    // My page league 페이지
    @Override
    public CliLeagueServiceVO getMyLeague(HttpServletRequest request) {
        LocalDate now = LocalDate.now();
        CliLeagueServiceVO cliLeagueServiceVO = new CliLeagueServiceVO();

        // memberId 값 불러오기
        cliLeagueServiceVO.getLoginedMember().setMemberId("memberId");

        // List<LeagueVO> 불러오기
        List<LeagueVO> list = cliLeagueMapper.getLeagueList();

        List<LeagueVO> participatedLeague = new ArrayList<>();
        List<LeagueVO> notParticipatedLeague = new ArrayList<>();

        // 참가한 리그, 참가하지 않은 리그 분리
        list.forEach(league -> {
            LeagueApplyVO leagueApplyVO = new LeagueApplyVO();
            // 리그에 참가했는지 검증
            leagueApplyVO.setLeagueId(league.getLeagueId());
            leagueApplyVO.setMemberId(request.getSession().getAttribute("memberId").toString());


            // 리그 참여 후 상태 체크
            league.setIsApplyStatus(cliLeagueMapper.isLeagueApplyStatus(league.getLeagueId()));


            // league 참가 여부 확인
            if( cliLeagueMapper.isLeagueApply(leagueApplyVO).size() > 0 ) {

                    league.setIsApply("y");
                    participatedLeague.add(league);

            } else {
                // 참가하지 않은 리그

                    league.setIsApply("n");
                    notParticipatedLeague.add(league);

            }

        });

        // retrun serviceVO 에 담음
        cliLeagueServiceVO.setParticipatedLeague(participatedLeague);
        cliLeagueServiceVO.setNotParticipatedLeague(notParticipatedLeague);

        // 반환
        return cliLeagueServiceVO;
    }

    // 리그 상세조회
    @Override
    public CliLeagueServiceVO getLeagueDetail(int lno, String memberId) {

        CliLeagueServiceVO leagueServiceVO = new CliLeagueServiceVO();

        // 멤버 조회
        leagueServiceVO.loginedMember.setMemberId(memberId);
        leagueServiceVO.loginedMember = memberMapper.selectMember(leagueServiceVO.loginedMember);

        // 리그 조회
        leagueServiceVO.leagueVO = cliLeagueMapper.getLeagueDetail(lno);


        // team 입력
        leagueServiceVO.teamVO = teamMapper.selectTeam(leagueServiceVO.loginedMember.getTeamId());

        leagueServiceVO.teamMembers = teamMapper.selectTeamMembers(leagueServiceVO.loginedMember.getTeamId());

//        System.out.println("result = " + result);


        if(leagueServiceVO.loginedMember != null)
            return leagueServiceVO;
        else
            return null;

    }

    // 리그 신청 처리
    @Override
    public void insertLeagueApply(CliLeagueServiceVO cliLeagueServiceVO, List<Map<String, Object>> getLeagueParticipatedMember) {

        // memberId 에 들어갈 String list
        List<String> ddd = new ArrayList<>();
        if (getLeagueParticipatedMember != null) {
            for(int i=0; i<getLeagueParticipatedMember.size(); i++) {
//          dd[0] += returnVal.get(i).get("value");
                ddd.add(getLeagueParticipatedMember.get(i).get("value").toString());
            }

            LeagueApplyVO leagueApplyVO = new LeagueApplyVO();

            // 참가하는 모든 멤버
            for(int i=0; i<ddd.size(); i++) {

                leagueApplyVO.setLeagueId(cliLeagueServiceVO.getLeagueVO().getLeagueId());
                // default 값
                leagueApplyVO.setIsApprove("1801");
                // 각 멤버 입력
                leagueApplyVO.setMemberId(getLeagueParticipatedMember.get(i).get("value").toString()); // 팀 전체 멤버 입력
                leagueApplyVO.setTeamMember(ddd.toString().substring(1, ddd.toString().length()-1) );
                // teamId 입력
                leagueApplyVO.setTeamId(cliLeagueServiceVO.getTeamVO().getTeamId());

                System.out.println("======================leagueApplyVO = " + leagueApplyVO);
                cliLeagueMapper.submitLeagueApply(leagueApplyVO);
            }
        }
    }

    // league_apply table 에 로그인한 회원이 신청한 리그를 조회
    @Override
    public List<LeagueApplyVO> checkLeagueApply(LeagueApplyVO leagueApplyVO) {

        return cliLeagueMapper.isLeagueApply(leagueApplyVO);
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
