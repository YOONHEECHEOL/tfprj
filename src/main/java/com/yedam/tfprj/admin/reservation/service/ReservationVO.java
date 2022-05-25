package com.yedam.tfprj.admin.reservation.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ReservationVO {
    private int resId;
    private String memberId;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date endTime;
    private int room;
    private String statusCd;
    private int gameId;
    private Date resDate;
    private String tel;
    private String name;
    private String paymentId;
    private String paymentStatusCd;
    private String paymentMethodCd;
}
