package com.yedam.tfprj.client.message.service;

import lombok.Data;

import java.util.Date;

@Data
public class AttendMsgVO {
    private String workerId;
//    private String chkTime; // 출근시간, 퇴근시간 -> 시간
    private String chkWork;

    @Override
    public String toString() {
        return "[" + workerId + "] 님이 " + chkWork +"하셨습니다. ";
    }
}
