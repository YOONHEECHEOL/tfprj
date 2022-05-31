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

        // 마지막 팀은 부전승


        // 예약 처리하기,


    }

}
