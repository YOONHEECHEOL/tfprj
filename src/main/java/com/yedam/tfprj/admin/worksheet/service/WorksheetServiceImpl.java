package com.yedam.tfprj.admin.worksheet.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.worksheet.mapper.WorksheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorksheetServiceImpl implements WorksheetService {

    @Autowired
    WorksheetMapper mapper;

    @Override
    public String jsonSheetList() {
        List<WorksheetVO> list = mapper.sheetList();
        List<Map<String, Object>> jsonList = new ArrayList<>();
        Map<String, Object> map;

        for(int i=0; i<list.size(); i++){
            map = new HashMap<String, Object>();
            map.put("title", list.get(i).getWorkSheetNo());
            map.put("start", list.get(i).getWorkStartTime());
            map.put("end", list.get(i).getWorkEndTime());

            jsonList.add(map);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String strJsonList = "";
        try {
            strJsonList = objectMapper.writeValueAsString(jsonList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return strJsonList;
    }
}
