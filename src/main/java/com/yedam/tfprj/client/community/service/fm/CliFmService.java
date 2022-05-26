package com.yedam.tfprj.client.community.service.fm;

import java.util.List;

public interface CliFmService {
    public List<CliFmVO> CliFmList(CliFmVO vo);

    CliFmVO CliFmSelect(CliFmVO vo);

    public void CliFmDelete(CliFmVO vo);

    public void CliFmUpdate(CliFmVO vo);

    public void CliFmInsert(CliFmVO vo);

    public List<CliFmVO> CliReplyList(CliFmVO vo);

    public void CliFmAnswerInsert(CliFmVO vo);

    public void CliFmAnswerDelete(CliFmVO vo);
}
