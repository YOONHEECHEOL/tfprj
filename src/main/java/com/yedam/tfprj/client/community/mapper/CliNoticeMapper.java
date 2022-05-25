package com.yedam.tfprj.client.community.mapper;

import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliNoticeMapper {
    public List<CliNoticeVO> CliNoticeList(CliNoticeVO vo);
    CliNoticeVO CliNoticeSelect(CliNoticeVO vo);
}
