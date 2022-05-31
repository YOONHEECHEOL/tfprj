package com.yedam.tfprj.client.reservation.service;

import lombok.Data;

@Data
public class GameVO {
    private int gameId;
    private int resId;
    private String memberId;
    private String memberName;
    private int innings;
    private int homeScore;
    private int awayScore;
    private int homeHits;
    private int awayHits;
    private int homeHomeruns;
    private int awayHomeruns;
    private int homePlayteamCd;
    private int awayPlayteamCd;
    private int winLose;
    private int leagueId;
    private int roundCd;
    private int room;
}
