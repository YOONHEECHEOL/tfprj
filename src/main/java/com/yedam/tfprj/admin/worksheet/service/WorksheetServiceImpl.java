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
            map.put("title", list.get(i).getWorkerId());
            map.put("start", list.get(i).getGoingTime());
            map.put("end", list.get(i).getQuittingTime());
            map.put("color", list.get(i).getColor());
            map.put("textColor", list.get(i).getTextColor());
            map.put("backgroundColor", list.get(i).getBackgroundColor());
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

    @Override
    public int insertWorksheet(WorkerArrVO vo ) {
        return mapper.insertWorksheet( vo);
    }

    @Override
    public List<WorksheetVO> worksheetList() {
        return mapper.worksheetList();
    }

    @Override
    public List<WorksheetVO> sheetValidation(String firstDate, String lastDate) {
        return mapper.sheetValidation(firstDate, lastDate);
    }

    @Override
    public int updateWorksheet(String workerId, String goingTime, String quittingTime, String color, String textColor, String backgroundColor) {
        return mapper.updateWorksheet(workerId, goingTime, quittingTime, color, textColor, backgroundColor);
    }

    @Override
    public WorksheetVO validateWorkTime(String workerId) {
        return mapper.validateWorkTime(workerId);
    }

    @Override
    public List<NewWorkSheetVO> selectNextWorker() {
        return mapper.selectNextWorker();
    }

    @Override
    public List<NewWorkSheetVO> yesterDayWorker() {
        return mapper.yesterDayWorker();
    }

    @Override
    public int updateWeekend(String firstDate, String lastDate) {
        return mapper.updateWeekend(firstDate, lastDate);
    }

    @Override
    public int deleteCalendar(String firstDate, String lastDate) {
        return mapper.deleteCalendar(firstDate, lastDate);
    }

    @Override
    public List<WorksheetVO> checkDateBeforeDelete(String firstDate, String lastDate) {
        return mapper.checkDateBeforeDelete(firstDate, lastDate);
    }
}
