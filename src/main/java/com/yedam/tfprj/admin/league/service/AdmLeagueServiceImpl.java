package com.yedam.tfprj.admin.league.service;

import com.yedam.tfprj.admin.league.mapper.AdmLeagueMapper;
import com.yedam.tfprj.client.league.service.LeagueVO;
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
    public AdmLeagueServiceVO getLeagueDetail(int lno) {
        return null;
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
}
