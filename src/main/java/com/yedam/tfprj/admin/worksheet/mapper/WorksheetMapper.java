package com.yedam.tfprj.admin.worksheet.mapper;

import com.yedam.tfprj.admin.worksheet.service.WorksheetVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorksheetMapper {
    public List<WorksheetVO> sheetList();

}
