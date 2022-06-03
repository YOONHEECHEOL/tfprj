package com.yedam.tfprj.admin.reservation.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberGameVO {
    private String memberId;
    private String memberName;
    private int groundCd;
    private int hits;
    private int homeruns;
    private int highestDistance;
    private int batCounts;
    private int batOrder;
    private int difficultyCd;
    private int gameId;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh24:mm:ss", timezone = "Asia/Seoul")
    private Date res_date;
    private double battingAverage;



}
