package com.yedam.tfprj.admin.community.mapper;

import com.yedam.tfprj.admin.community.service.notice.AdmNoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmNoticeMapper {
    public List<AdmNoticeVO> AdmNoticeList(AdmNoticeVO vo);
    AdmNoticeVO AdmNoticeSelect(AdmNoticeVO vo);
    public void AdmNoticeDelete(AdmNoticeVO vo);

    public void AdmNoticeUpdate(AdmNoticeVO vo);
    public void AdmNoticeInsert(AdmNoticeVO vo);
    public void AdmNoticeViewCount(int nNo);

}
