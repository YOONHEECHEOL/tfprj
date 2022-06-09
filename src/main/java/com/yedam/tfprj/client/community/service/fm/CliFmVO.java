package com.yedam.tfprj.client.community.service.fm;

import lombok.Data;

@Data
public class CliFmVO {
    private int fNo;
    private String  title;
    private String  writer;
    private String  wdate;
    private int     views;
    private String  details;
    private String  teamName;
    private int     cNo;
    private String  cdate;
    private String  cdetails;
    private String  cwriter;
}
