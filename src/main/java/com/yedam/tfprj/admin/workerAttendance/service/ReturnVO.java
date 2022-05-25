package com.yedam.tfprj.admin.workerAttendance.service;

import lombok.Data;

@Data
public class ReturnVO {
    private long time;
    private String late;
    private String absence;
    private long minute;

    private WorkerAttendanceVO vo;
}
