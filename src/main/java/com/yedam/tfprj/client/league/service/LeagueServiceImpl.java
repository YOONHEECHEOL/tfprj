package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.league.mapper.LeagueMapper;
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

    public LocalDate toLocalDateInstant(Date dateToConvert) {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String returnDate = dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().format(formatter);

        return LocalDate.parse(returnDate);
    }


}
