package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.client.league.mapper.LeagueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService{

//    @Autowired
//    LeagueMapper leagueMapper;

    @Override
    public String sayHi() {
        return "hi";
    }

}
