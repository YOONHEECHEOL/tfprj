package com.yedam.tfprj.admin.community.service.fm;

import lombok.Data;

@Data
public class AdmFmVO {
    private int fNo;
    private String  title;
    private String  writer;
    private String  wdate;
    private int     views;
    private String  details;
    private String  team;
    private int     cNo;
    private String  cdate;
    private String  cdetails;
    private String  cwriter;
    private Integer viewCount;
    private String  type;
    private String  keyword;
}
