package com.yedam.tfprj.client.community.service.qna;

import java.util.List;

public interface CliQnaService {
    public List<CliQnaVO> CliQnaList(CliQnaVO vo);

    CliQnaVO  CliQnaSelect(CliQnaVO vo);

    public void CliQnaDelete(CliQnaVO vo);

    public void CliQnaUpdate(CliQnaVO vo);

    public void CliQnaInsert(CliQnaVO vo);

    public List<CliQnaVO> CliReplyList(CliQnaVO vo);

    public void CliQnaAnswerInsert(CliQnaVO vo);

    public void CliQnaAnswerDelete(CliQnaVO vo);
    public void CliQnaViewCount(int qNo);

}
