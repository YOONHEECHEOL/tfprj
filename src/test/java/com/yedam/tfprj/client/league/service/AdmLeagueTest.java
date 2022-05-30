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

      // 대진표 만들기 시작
      // 대진표 생성 버튼 클릭, @RequestBody List
      List<Map<String, String>> paramApproveTeam = new ArrayList<>();

      Map<String, String> param = new HashMap<>();
      param.put("teamId", "맛없는사슴");


      // 승인된 팀 리스트
      List<Map<String, String>> approvedTeam = new ArrayList<>();

      // 짝수일 때
      if(approvedTeam.size() % 2 != 1) {
        // 짝수
//        <svg xmlns="http://www.w3.org/2000/svg" width="23" height="45" viewBox="0 0 23 45" fill="none">
//        <path d="M0.5 1C4.83333 1 14.3 1 17.5 1C21.5 1 22.5 3 22.5 6C22.5 8.4 22.5 33 22.5 45" stroke="black"/>
//        </svg>

      } else {
        // 홀수


      }

      // 홀수일 때


      // 예약 처리하기,


    }

}
