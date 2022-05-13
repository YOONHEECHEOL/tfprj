package com.yedam.tfprj.client.league.service;

import lombok.Data;

import java.util.List;

@Data
public class LeagueCurrentPassedVO {

    private List<LeagueVO> currentList;
    private List<LeagueVO> passedList;

}
