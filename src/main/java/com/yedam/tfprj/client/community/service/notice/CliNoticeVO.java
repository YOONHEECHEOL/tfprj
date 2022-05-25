package com.yedam.tfprj.client.community.service.notice;

import lombok.Data;

@Data
public class CliNoticeVO {
    private int     nNo;
    private String  title;
    private String  wdate;
    private int     views;
    private String  details;
}
