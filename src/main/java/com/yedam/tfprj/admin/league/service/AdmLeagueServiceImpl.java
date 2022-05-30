package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.admin.league.mapper.AdmLeagueMapper;
import com.yedam.tfprj.client.league.service.LeagueApplyVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdmLeagueServiceImpl implements LeagueService{

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
            if( now.isBefore( toLocalDateInstant( league.getEndDate() ) ) )
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
            admLeagueServiceVO.leagueVO = admLeagueMapper.getLeagueDetail(leagueId);                    }
        catch (Exception e) {
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
            if(admLeagueMapper.getLeagueApplyTeamIsApprove(team.getTeamId(), leagueId) > 0) {
                // 리그 참가 승인된 팀
                approveTeam.add(team);
            } else {
                applyTeam.add(team);
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
            if(admLeagueMapper.getLeagueApplyTeamIsApprove(team.getTeamId(), leagueId) > 0) {
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
        admLeagueMapper.setLeagueApplyTeamStatus(teamId, leagueId);
    }
}
