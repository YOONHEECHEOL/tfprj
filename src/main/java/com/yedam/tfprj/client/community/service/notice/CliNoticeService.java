package com.yedam.tfprj.client.community.service.notice;

import java.util.List;

public interface CliNoticeService {
    public List<CliNoticeVO> CliNoticeList(CliNoticeVO vo);

    CliNoticeVO CliNoticeSelect(CliNoticeVO vo);
    public void CliNoticeViewCount(int qNo);

}
