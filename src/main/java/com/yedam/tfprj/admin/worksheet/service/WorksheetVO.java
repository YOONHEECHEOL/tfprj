package com.yedam.tfprj.admin.worksheet.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WorksheetVO {
    private int workSheetNo;
    private Date workDt;
    private String workerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date workStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date workEndTime;
}
