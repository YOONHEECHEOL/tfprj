package com.yedam.tfprj.client.league.service;

import lombok.Data;

@Data
public class LeagueApplyVO {

    private int leagueApplyId;
    private int leagueId;
    private String teamMember;
    private String isApprove; // 공통코드 삽입
    private String memberId;
    private int entryFee;
    private int teamId;

}
