package com.yedam.tfprj.client.reservation.service;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation {
    private int resId;
    private String memberId;
    private Date startTime;
    private Date endTime;
    private int room;
    private String status;
    private int gameId;
    private Date resDate;
    private String tel;
    private String name;
}
