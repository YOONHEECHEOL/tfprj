package com.yedam.tfprj.admin.community.mapper;


import com.yedam.tfprj.admin.community.service.qna.AdmQnaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmQnaMapper {
    public List<AdmQnaVO> AdmQnaList(AdmQnaVO vo);

}