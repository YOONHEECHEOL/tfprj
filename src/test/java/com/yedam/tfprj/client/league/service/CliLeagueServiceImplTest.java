package com.yedam.tfprj.client.league.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CliLeagueServiceImplTest {

  ObjectMapper obejectMapper = new ObjectMapper();

  @Test
    void getLeagueParticipatedMember() {

        String formVal = "[{\"name\":\"lno\",\"value\":\"1\"},{\"name\":\"formVal\",\"value\":\"\"},{\"name\":\"fs0\",\"value\":\"lee\"},{\"name\":\"fs1\",\"value\":\"lee\"},{\"name\":\"fs2\",\"value\":\"lee\"},{\"name\":\"fs3\",\"value\":\"lee\"}]";

        ObjectMapper obejectMapper = new ObjectMapper();

        try {
            List<Map<String, Object>> returnVal = obejectMapper.readValue(formVal, new TypeReference<List<Map<String, Object>>>() {});
            System.out.println("returnVal = " + returnVal);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void insertLeagueApply() {

      CliLeagueServiceVO cliLeagueServiceVO = new CliLeagueServiceVO();
//      List<Map<String, Object>> getLeagueParticipatedMember =

      String formVal = "[{\"name\":\"lno\",\"value\":\"1\"},{\"name\":\"formVal\",\"value\":\"\"},{\"name\":\"fs0\",\"value\":\"lee\"},{\"name\":\"fs1\",\"value\":\"lee\"},{\"name\":\"fs2\",\"value\":\"lee\"},{\"name\":\"fs3\",\"value\":\"lee\"}]";

      List<Map<String, Object>> returnVal = null;
      try {
        returnVal = obejectMapper.readValue(formVal, new TypeReference<List<Map<String, Object>>>() {});
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      final String[] dd = {""};
      List<String> ddd = new ArrayList<>();
//      if (returnVal != null) {
//        returnVal.forEach(res -> {
//          String rd = res.get("value").toString() + " ";
//          dd[0] += rd;
//        });
//      }
      if (returnVal != null) {
        for(int i=2; i<returnVal.size(); i++) {
//          dd[0] += returnVal.get(i).get("value");
            ddd.add(returnVal.get(i).get("value").toString());
        }
      }

      if (returnVal != null) {
        for(int i=2; i<returnVal.size(); i++) {
          LeagueApplyVO leagueApplyVO = new LeagueApplyVO();

//        leagueApplyVO.setLeagueId(cliLeagueServiceVO.getLeagueVO().getLeagueId());
          leagueApplyVO.setIsApprove("501");
//        leagueApplyVO.setEntryFee(cliLeagueServiceVO.getLeagueVO().getEntryFee());
          leagueApplyVO.setMemberId(ddd.toString().substring(1, ddd.toString().length()-1) ); // 팀 전체 멤버 입력
          leagueApplyVO.setTeamMember(returnVal.get(i).get("value").toString());

          System.out.println("======================leagueApplyVO = " + leagueApplyVO);
        }
      }
//      returnVal.forEach(res -> {
//        LeagueApplyVO leagueApplyVO = new LeagueApplyVO();
//
////        leagueApplyVO.setLeagueId(cliLeagueServiceVO.getLeagueVO().getLeagueId());
//        leagueApplyVO.setIsApprove("501");
////        leagueApplyVO.setEntryFee(cliLeagueServiceVO.getLeagueVO().getEntryFee());
//        leagueApplyVO.setMemberId(ddd.get(1)); // 팀 전체 멤버 입력
//        leagueApplyVO.setTeamMember(res.get("value").toString());
//
//        System.out.println("======================leagueApplyVO = " + leagueApplyVO);
//
////        cliLeagueMapper.submitLeagueApply(leagueApplyVO);
//      });
    }


}