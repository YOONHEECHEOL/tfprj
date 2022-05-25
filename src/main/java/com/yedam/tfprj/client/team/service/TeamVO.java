package com.yedam.tfprj.client.team.service;

import lombok.Data;

@Data
public class TeamVO {

    private int teamId;
    private String leader;
    private int win;
    private int totalGameCnt;
    private String teamName;
    private int ROWNUM;

}
