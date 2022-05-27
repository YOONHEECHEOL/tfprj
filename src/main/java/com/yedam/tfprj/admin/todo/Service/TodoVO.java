package com.yedam.tfprj.admin.todo.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class TodoVO {

    private int chkNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date chkMakeDate;

    private String chkContents;
    private String chkPicFileName;
    private String chkPicFilePath;
    private String originalFileName;
    private int isChk;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date chkTime;

    private String workerId;
    private String commentContent;

    private List<CheckVO> vo;

}
