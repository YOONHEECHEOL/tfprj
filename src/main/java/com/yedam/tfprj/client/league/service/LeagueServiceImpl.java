package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.league.mapper.LeagueMapper;
import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService{

    @Autowired
    LeagueMapper leagueMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public LeagueCurrentPassedVO getLeagueList() {
        LocalDate now = LocalDate.now();
        List<LeagueVO> leagueList = leagueMapper.getLeagueList();
        LeagueCurrentPassedVO leagueCurrentPassed = new LeagueCurrentPassedVO();

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
    public LeagueVO getLeagueDetail(int lno, String memberId) {

        // session - memberId를 통해 팀 조회
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);
        memberVO = memberMapper.selectMember(memberVO);

//        if(memberVO.getTeamId() != ) {
//
//        }

        return leagueMapper.getLeagueDetail(lno);
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
