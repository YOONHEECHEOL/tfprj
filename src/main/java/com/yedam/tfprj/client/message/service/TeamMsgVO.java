package com.yedam.tfprj.client.message.service;

import lombok.Data;

@Data
public class TeamMsgVO {

    private String leader;
    private String teamName;
    private String memberId;
    private int teamId;
    // message insert 할 때 날짜
    private String today;

    @Override
    public String toString() {
        return "[" + teamName + "] 에서 초대가 왔습니다. (팀장:" +
                leader + ")";
    }
}
