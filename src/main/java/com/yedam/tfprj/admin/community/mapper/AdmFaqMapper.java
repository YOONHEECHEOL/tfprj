package com.yedam.tfprj.admin.community.mapper;

import com.yedam.tfprj.admin.community.service.faq.AdmFaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmFaqMapper {
    public List<AdmFaqVO> AdmFaqList(AdmFaqVO vo);

    public List<AdmFaqVO> AdmFaqTitleList(AdmFaqVO vo);

    public void AdmFaqInsert(AdmFaqVO vo);

    public void AdmFaqTitleInsert(AdmFaqVO vo);
}
