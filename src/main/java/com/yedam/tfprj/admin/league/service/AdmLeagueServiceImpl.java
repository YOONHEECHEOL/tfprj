package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.admin.league.mapper.AdmLeagueMapper;
import com.yedam.tfprj.client.league.mapper.CliLeagueMapper;
import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AdmLeagueServiceImpl implements LeagueService {

  @Autowired
  AdmLeagueMapper admLeagueMapper;

  @Override
  public AdmLeagueServiceVO getLeagueList() {
    LocalDate now = LocalDate.now();

    List<LeagueVO> leagueList = admLeagueMapper.getLeaugeList();
    AdmLeagueServiceVO admLeagueServiceVO = new AdmLeagueServiceVO();

    admLeagueServiceVO.currentList = new ArrayList<>();
    admLeagueServiceVO.passedList = new ArrayList<>();

    // 분할
    leagueList.forEach(league -> {
      if (now.isBefore(toLocalDateInstant(league.getEndDate())))
        admLeagueServiceVO.currentList.add(league);
      else
        admLeagueServiceVO.passedList.add(league);
    });

    return admLeagueServiceVO;
  }

  @Override
  public AdmLeagueServiceVO getLeagueDetail(int leagueId) {

    AdmLeagueServiceVO admLeagueServiceVO = new AdmLeagueServiceVO();

    List<TeamVO> approveTeam = new ArrayList<>();
    List<TeamVO> applyTeam = new ArrayList<>();

    try {
      admLeagueServiceVO.leagueVO = admLeagueMapper.getLeagueDetail(leagueId);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // admLeagueMapper.getLeagueApply(leagueId) 리그 지원한 팀 전체 조회
    List<TeamVO> list = admLeagueMapper.getLeagueApplyTeam(leagueId);

    list.forEach(team -> {
      // team is_approve set

      int isApprove = 1800;
      System.out.println("team = " + team.getTeamId());
      System.out.println("leagueId = " + leagueId);
      try {
        isApprove = Integer.parseInt(admLeagueMapper.getIsApprove(leagueId, team.getTeamId()));
      } catch (Exception e) {
        e.printStackTrace();
      }

      team.setIsApprove(isApprove);

      // team is_approve 가 1805 인지 체크
      try {
        System.out.println("admLeagueMapper.getLeagueApplyTeamIsApprove(leagueId, team.getTeamId()) = " + admLeagueMapper.getLeagueApplyTeamIsApprove(leagueId, team.getTeamId()));
        if (admLeagueMapper.getLeagueApplyTeamIsApprove(leagueId, team.getTeamId()) > 0) {
          // 리그 참가 승인된 팀
          approveTeam.add(team);
        } else {
          applyTeam.add(team);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      admLeagueServiceVO.setLeagueApplyApproveTeam(approveTeam);
      admLeagueServiceVO.setLeagueApplyTeam(applyTeam);
    });

    return admLeagueServiceVO;
  }

  @Override
  public void insertLeague(LeagueVO leagueVO) {

    admLeagueMapper.insertLeague(leagueVO);

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

  @Override
  public AdmLeagueServiceVO getLeagueApply(int leagueId) {

    AdmLeagueServiceVO admLeagueServiceVO = new AdmLeagueServiceVO();
    admLeagueServiceVO.setLeagueApplyVOList(admLeagueMapper.getLeagueApply(leagueId));

    return admLeagueServiceVO;
  }

  @Override
  public AdmLeagueServiceVO getLeagueApplyTeam(int teamId, int leagueId) {

    AdmLeagueServiceVO admLeagueServiceVO = new AdmLeagueServiceVO();

    // league apply is_approve 가 1801 인 팀과 1803 인 팀 분리
    List<TeamVO> list = admLeagueMapper.getLeagueApplyTeam(leagueId);

    List<TeamVO> approveTeam = new ArrayList<>();
    List<TeamVO> applyTeam = new ArrayList<>();

    list.forEach(team -> {
      // teamVO 에 is_approve 상태를 league_apply 테이블에서 조회해서 넣음
      team.setIsApprove(Integer.parseInt(admLeagueMapper.getIsApprove(team.getTeamId(), leagueId)));
      if (admLeagueMapper.getLeagueApplyTeamIsApprove(team.getTeamId(), leagueId) > 0) {
        // 해당 team은 승인된 팀입니다.
//              league apply is_approve = 1805
        approveTeam.add(team);
      } else {
        // 해당 team은 미승인 팀입니다.
//             league apply is_approve = 1801
        applyTeam.add(team);
      }

    });

    admLeagueServiceVO.setLeagueApplyApproveTeam(approveTeam);
    admLeagueServiceVO.setLeagueApplyTeam(applyTeam);

    return admLeagueServiceVO;
  }

  @Override
  public void setLeagueApplyTeamStatus(int teamId, int leagueId) {
    String isApprove = admLeagueMapper.getIsApprove(leagueId, teamId);

    if (isApprove.equals("1804")) {
      admLeagueMapper.setLeagueApplyTeamStatus(teamId, leagueId, 1805);
    } else {
      admLeagueMapper.setLeagueApplyTeamStatus(teamId, leagueId, 1804);
    }
  }

  // league_status 해당 league 경기 중인 팀들 모두 불러오기
  @Override
  public AdmLeagueServiceVO getLeagueStatusTable(int leagueId) {
    // return 용
    AdmLeagueServiceVO admLeagueServiceVO = new AdmLeagueServiceVO();

    // league 정보 불러오기
    LeagueVO leagueVO = admLeagueMapper.getLeagueDetail(leagueId);

    // 반환값
    List<Map<String, Object>> returnMap = new ArrayList<>();

    // List<Map<String, String> 만들기 위한 인덱스 객체 만들기
    double pcnt = leagueVO.getParticipationTeam();

    // 인덱스 용 객체
    List<Double> cntArr = new ArrayList<>();

    while(pcnt > 1) {
      cntArr.add(pcnt);
      System.out.println("cntArr = " + cntArr);
      pcnt = Math.floor(pcnt / 2) + Math.floor(pcnt % 2);
    }
    cntArr.add(pcnt);

    // 해당 리그 전체 경기 정보 불러오기
    List<LeagueStatusVO> returnVal = new ArrayList<>();
    returnVal = admLeagueMapper.getLeagueStatus(leagueId);

    // 인덱스에 맞게 List<Map<String, String> 객체 만들어 List<Map<String, Object>> re 객체에 답기
    // 분리하는 부분
    List<LeagueStatusVO> finalReturnVal = returnVal;

    cntArr.forEach(index -> {
      List<LeagueStatusVO> v = new ArrayList<>();
      for(int i=0; i<index; i++) {
        v.add(finalReturnVal.get(i));
      }
      // map 에 정보 담기
      Map<String, Object> vv = new HashMap<>();
      vv.put("game", v);

      // 최종 반환값에 map 담기
      returnMap.add(vv);
    });

    // return 담기
    admLeagueServiceVO.setLeagueStatusTeamList(returnMap);

    return admLeagueServiceVO;
  }


  @Override
  public void insertLeagueStatus(List<Map<String, String>> param) {

    int leagueId = Integer.parseInt(param.get(0).get("leagueId"));
    int status = Integer.parseInt(param.get(1).get("status"));

    // insert into league_status table
    param.forEach(l -> {
      if (l.containsKey("teamId")) {
        admLeagueMapper.insertLeagueStatus(status, leagueId, l.get("teamId"), Integer.parseInt(l.get("gameCnt")));
      }
    });

  }
}

