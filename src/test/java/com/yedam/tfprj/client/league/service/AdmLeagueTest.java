package com.yedam.tfprj.client.league.service;

import com.yedam.tfprj.admin.league.mapper.AdmLeagueMapper;
import com.yedam.tfprj.admin.league.service.AdmLeagueServiceImpl;
import com.yedam.tfprj.admin.league.service.AdmLeagueServiceVO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdmLeagueTest {


  @Test
  public void getLeagueApplyTeamIsApprove() {

    double pcnt = 8;

    List<Double> cntArr = new ArrayList<>();

    while(pcnt > 1) {
      pcnt = Math.floor(pcnt / 2) + Math.floor(pcnt % 2);
      cntArr.add(pcnt);
      System.out.println("cntArr = " + cntArr);
    }

    System.out.println("최종 = " + cntArr);
    
  }

}
