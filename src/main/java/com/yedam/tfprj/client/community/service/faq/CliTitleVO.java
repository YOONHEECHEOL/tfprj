package com.yedam.tfprj.client.community.service.faq;

import lombok.Data;

import java.util.List;

@Data
public class CliTitleVO {
    private  String title;
    List<CliFaqVO> cliFaqList;
}
