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
}
