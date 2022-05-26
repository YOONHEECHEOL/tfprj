package com.yedam.tfprj.client.message.service;

import lombok.Data;

@Data
public class MessageVO {

    private int messageId;
    private String date;
    private int isChk;
    private String messageContents;
    private int isMessageCd;
    private String memberId;
    private String temp;

}
