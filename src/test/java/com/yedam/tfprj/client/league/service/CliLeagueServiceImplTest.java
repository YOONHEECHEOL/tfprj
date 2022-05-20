package com.yedam.tfprj.client.league.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CliLeagueServiceImplTest {

    @Test
    void getLeagueParticipatedMember() {

        String formVal = "[{\"name\":\"lno\",\"value\":\"1\"},{\"name\":\"formVal\",\"value\":\"\"},{\"name\":\"fs0\",\"value\":\"lee\"},{\"name\":\"fs1\",\"value\":\"lee\"},{\"name\":\"fs2\",\"value\":\"lee\"},{\"name\":\"fs3\",\"value\":\"lee\"}]";

        ObjectMapper obejectMapper = new ObjectMapper();

        try {
            List<Map<String, Object>> returnVal = obejectMapper.readValue(formVal, new TypeReference<List<Map<String, Object>>>() {
            });
            System.out.println("returnVal = " + returnVal);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}