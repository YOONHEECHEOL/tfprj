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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date rgstDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date endDate;

    private int prizeMoney;
    private String winningTeam;
    private String leagueStatusCd;
    private int tournamentId;
    private int entryFee;

}
