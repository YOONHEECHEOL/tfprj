package com.yedam.tfprj;

import com.yedam.tfprj.client.league.service.LeagueServiceVO;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CommonCodeTest {

  @Test
  public void convertCommonCode() {
    LeagueServiceVO leagueServiceVO = new LeagueServiceVO();


//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<TeamVO> result = restTemplate.getForEntity("/cli/getTeam?teamId=" + leagueServiceVO.loginedMember.getTeamId(), TeamVO.class);
//
//    System.out.println("result = " + result);


  }

}
