package com.yedam.tfprj.client.community.mapper;

import com.yedam.tfprj.client.community.service.qna.CliQnaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CliQnaMapper {
    public List<CliQnaVO> CliQnaList(CliQnaVO vo);

    CliQnaVO CliQnaSelect(CliQnaVO vo);

    public void CliQnaDelete(CliQnaVO vo);

    public void CliQnaUpdate(CliQnaVO vo);

    public void CliQnaInsert(CliQnaVO vo);

    public List<CliQnaVO> CliReplyList(CliQnaVO vo);

    public void CliQnaAnswerInsert(CliQnaVO vo);

    public void CliQnaAnswerDelete(CliQnaVO vo);
    public void CliQnaViewCount(int qNo);

}
