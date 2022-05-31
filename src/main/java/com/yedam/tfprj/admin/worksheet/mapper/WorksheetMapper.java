package com.yedam.tfprj.admin.worksheet.mapper;

import com.yedam.tfprj.admin.worksheet.service.NewWorkSheetVO;
import com.yedam.tfprj.admin.worksheet.service.WorkerArrVO;
import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorksheetMapper {
    public List<WorksheetVO> sheetList();
    public int insertWorksheet( WorkerArrVO vo);
    public List<WorksheetVO> worksheetList();
    public List<WorksheetVO> sheetValidation(String firstDate, String lastDate);
    public int updateWorksheet(String workerId, String goingTime, String quittingTime, String color, String textColor, String backgroundColor);
    public WorksheetVO validateWorkTime(String workerId);
    public List<NewWorkSheetVO> selectNextWorker();
    public List<NewWorkSheetVO> yesterDayWorker();

}
