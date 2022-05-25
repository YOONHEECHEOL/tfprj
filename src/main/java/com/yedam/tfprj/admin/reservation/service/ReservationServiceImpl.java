package com.yedam.tfprj.admin.reservation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.reservation.mapper.AdmReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    AdmReservationMapper mapper;

    @Override
    public String jsonResList() {
        List<ReservationVO> list = mapper.resList();
        System.out.println(list);
        List<Map<String, Object>> jsonList = new ArrayList<>();
        Map<String, Object> map;

        for(int i=0; i<list.size();i++){
            map = new HashMap<String, Object>();
            map.put("title", list.get(i).getGameId() + "번 게임");
            map.put("start", list.get(i).getStartTime());
            map.put("end", list.get(i).getEndTime());

            jsonList.add(map);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        String StrJsonList = "";
        try {
            StrJsonList = objectMapper.writeValueAsString(jsonList);
            System.out.println(StrJsonList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StrJsonList;
    }

    @Override
    public List<ReservationVO> dayResList(String startStr) {
        List<ReservationVO> list = mapper.dayResList(startStr);
        System.out.println(list);
        return list;
    }

    @Override
    public int updatePaymentCd(String resId) {
        mapper.updatePaymentCd(resId);
        return 0;
    }

    @Override
    public AdmGameVO gameInfo(String resId) {


        return mapper.gameInfo(resId);
    }

    @Override
    public List<MemberGameVO> gameInfoList(String resId) {
        List<MemberGameVO> giList = mapper.gameInfoList(resId);
        for(int i=0; i<giList.size();i++){

            double battingAverage = (double)giList.get(i).getHits()/giList.get(i).getBatCounts();
            double ba = Math.round(battingAverage*1000)/1000.0;
            giList.get(i).setBattingAverage(ba);
        }


        return giList;
    }

    @Override
    public ReservationVO resInfo(String resId) {

        return mapper.resInfo(resId);
    }

    @Override
    public String checkId(String memberId, String password, String memberName) {
        return mapper.checkId(memberId,password,memberName);
    }

    @Override
    public int updateId(String memberId, String memberName, String gameId) {
        return mapper.updateId(memberId,memberName,gameId);
    }


}
