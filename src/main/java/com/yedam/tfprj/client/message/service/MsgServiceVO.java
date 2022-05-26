package com.yedam.tfprj.client.message.service;

import lombok.Data;

import java.util.List;

@Data
public class MsgServiceVO {

    List<TeamMsgVO> teamMsgVO; // team 초대메세지
    ResMsgVO resMsgVO;

}
