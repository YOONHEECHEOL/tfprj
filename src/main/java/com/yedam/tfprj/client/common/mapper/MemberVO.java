package com.yedam.tfprj.client.common.mapper;

import lombok.Data;

@Data
public class MemberVO {
    private String member_id;
    private String member_name;
    private String tel;
    private int    grade;
    private String password;
    private int    blacklist_yn;
    private String blacklist_reason;
    private String trophy;
    private String preferred;
    private int    team_id;
}
