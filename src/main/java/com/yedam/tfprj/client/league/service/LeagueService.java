package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.league.mapper.LeagueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LeagueService {

    public LeagueCurrentPassedVO getLeagueList();

}
