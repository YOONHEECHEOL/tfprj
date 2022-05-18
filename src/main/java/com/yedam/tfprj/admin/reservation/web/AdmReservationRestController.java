package com.yedam.tfprj.admin.reservation.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.reservation.service.ReservationServiceImpl;
import com.yedam.tfprj.admin.reservation.service.ReservationSevice;
import com.yedam.tfprj.admin.reservation.service.ReservationVO;
import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdmReservationRestController {
    @Autowired
    ReservationSevice reservationServiceImpl;

    @GetMapping("/adm/reservation/reservation_list")
    public @ResponseBody String CalendarJson() {
        List<ReservationVO> list = reservationServiceImpl.resList();
        System.out.println(list);
        List<Map<String, Object>> jsonList = new ArrayList<>();
        Map<String, Object> map;

        for(int i=0; i<list.size();i++){
            map = new HashMap<String, Object>();
            map.put("title", list.get(i).getGameId());
            map.put("start", list.get(i).getStartTime());
            map.put("end", list.get(i).getEndTime());

            jsonList.add(map);
        }


        ObjectMapper mapper = new ObjectMapper();
        String StrJsonList = "";
        try {
            StrJsonList = mapper.writeValueAsString(jsonList);
            System.out.println(StrJsonList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StrJsonList;
    }
}
