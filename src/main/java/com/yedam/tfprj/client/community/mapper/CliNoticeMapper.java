package com.yedam.tfprj.client.community.mapper;

import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CliNoticeMapper {
    public List<CliNoticeVO> CliNoticeList(CliNoticeVO vo);
    CliNoticeVO CliNoticeSelect(CliNoticeVO vo);
    public void CliNoticeViewCount(int nNo);

    // 최근 3건 반환
  @Select("select * from (select * from NOTICE_BOARD order by WDATE desc) where ROWNUM < 4")
  public List<CliNoticeVO> getNoticeList();

}
