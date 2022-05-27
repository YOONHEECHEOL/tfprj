package com.yedam.tfprj.client.community.mapper;

import com.yedam.tfprj.client.community.service.fm.CliFmVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliFmMapper {
    public List<CliFmVO> CliFmList(CliFmVO vo);

    CliFmVO CliFmSelect(CliFmVO vo);

    public void CliFmDelete(CliFmVO vo);

    public void CliFmUpdate(CliFmVO vo);

    public void CliFmInsert(CliFmVO vo);

    public List<CliFmVO> CliReplyList(CliFmVO vo);

    public void CliFmAnswerInsert(CliFmVO vo);

    public void CliFmAnswerDelete(CliFmVO vo);
    public void CliFmViewCount(int fNo);

}
