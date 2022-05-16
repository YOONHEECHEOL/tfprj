package com.yedam.tfprj.client.member.service;

import lombok.Data;

@Data
public class MemberVO {
    private String memberId;
    private String memberName;
    private String tel;
    private int    grade;
    private String password;
    private int    blacklistYn;
    private String blacklistReason;
    private String trophy;
    private String preferred;
    private int    teamId;
}
