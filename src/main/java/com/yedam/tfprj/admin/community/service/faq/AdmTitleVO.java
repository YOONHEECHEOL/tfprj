package com.yedam.tfprj.admin.community.service.faq;

import lombok.Data;

import java.util.List;

@Data
public class AdmTitleVO {
    private  String title;
    List<AdmFaqVO> admFaqList;

}
