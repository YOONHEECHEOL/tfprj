package com.yedam.tfprj.admin.workerAttendance.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WorkerAttendanceVO {
    private int attId;
    private String workerId;
    private String attDt;
    private String inTime;
    private String outTime;
    private int isLate;
    private int isAbsence;
    private String workerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date goingTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date quittingTime;

    private int positionCd;
    private int userType;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date startDay;

    private long getTime;

    private String percent;
    private String inMTime;
    private String getMTime;
}
