package com.yedam.tfprj.admin.reservation.service;

import lombok.Data;

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
    private double battingAverage;


}
