package com.yedam.tfprj.admin.workerAttendance.service;

import lombok.Data;

@Data
public class PayrollVO {
    private String workerId;
    private String firstDate;
    private float allWorkTime;
    private int hWage;
    private float wage;
}
