package com.yedam.tfprj.client.member.service;

import lombok.Data;

@Data
public class GameVO {
    private int gameId;
    private int resId;
    private String memberId;
    private String ground;
    private int score;
    private int distance;
    private int hits;
    private int homerun;
    private int winLose;
    private int batCounts;
    private int innings;
    private String teamName;
    private String playteamCd;
    private int leagueId;
    private int order;
    private int difficultyCd;
    private int round;
}
