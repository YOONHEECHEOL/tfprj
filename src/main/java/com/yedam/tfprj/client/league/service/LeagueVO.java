package com.yedam.tfprj.client.league.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.chrono.ChronoLocalDate;
import java.util.Date;

@Data
public class LeagueVO {

    private int leagueId;
    private String leagueName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date rgstDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date endDate;

    private int prizeMoney;
    private int participationTeam;
    private int participationMember;
    private String prizeGood;
    private String winningTeam;
    private String leagueStatusCd;
    private int tournamentId;
    private int entryFee;

}
