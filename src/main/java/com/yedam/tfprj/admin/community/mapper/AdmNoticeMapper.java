package com.yedam.tfprj.admin.community.mapper;

import com.yedam.tfprj.admin.community.service.AdmNoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmNoticeMapper {
    public List<AdmNoticeVO> AdmNoticeList(AdmNoticeVO vo);
}
