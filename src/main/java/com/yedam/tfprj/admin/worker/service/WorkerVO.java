package com.yedam.tfprj.admin.worker.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WorkerVO {
    private String workerId;
    private String password;
    private int staffStatusCd;
    private String workerName;
    private String phoneNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date birth;

    private int militaryCd;
    private String memo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date startDay;

    private int allPay;
    private int payPerHour;
    private int positionCd;
    private int late;
    private int absence;
    private int userType;
    private String goingTime;
    private String quittingTime;
    private int gender;
    private int postcode;
    private String roadAddress;
    private String detailAddress;
    private String jibunAddress;

    private String fileName;
    private String filePath;
    private String originalFileName;
}
