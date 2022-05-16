package com.yedam.tfprj.admin.worker.mapper;

import lombok.Data;

import java.util.Date;

@Data
public class WorkerVO {
    private String workerId;
    private String password;
    private int staffStatusCd;
    private String workerName;
    private String profilePic;
    private String phoneNo;
    private Date birth;
    private int militaryCd;
    private String address;
    private String memo;
    private Date startDay;
    private String positionCd;
    private int late;
    private int absence;
    private int userType;
    private Date goingTime;
    private Date quittingTime;
}
