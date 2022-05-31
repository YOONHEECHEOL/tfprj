package com.yedam.tfprj.admin.worksheet.service;

import java.util.List;

public interface WorksheetService {
      public String jsonSheetList();
      public int insertWorksheet(WorkerArrVO vo );

      public List<WorksheetVO> worksheetList();
      public List<WorksheetVO> sheetValidation(String firstDate, String lastDate);
      public int updateWorksheet(String workerId, String goingTime, String quittingTime, String color, String textColor, String backgroundColor);

      public WorksheetVO validateWorkTime(String workerId);
      public List<NewWorkSheetVO> selectNextWorker();
      public List<NewWorkSheetVO> yesterDayWorker();
   }
