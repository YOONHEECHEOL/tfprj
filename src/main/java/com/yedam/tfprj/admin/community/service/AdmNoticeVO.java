package com.yedam.tfprj.admin.community.service;

import lombok.Data;

@Data
public class AdmNoticeVO {
    private int     nNo;
    private String  title;
    private String  wdate;
    private int     views;
    private String  details;
}
