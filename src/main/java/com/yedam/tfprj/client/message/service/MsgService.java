package com.yedam.tfprj.client.message.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MsgService {
    //메시지 조회
    public List<MessageVO> getMessage(HttpServletRequest request);

    //팀초대 메시지 조회
    public MsgServiceVO getTeamMsg(HttpServletRequest request);

    //팀초대 메시지 전송
    public void insertTeamMsg(TeamMsgVO teamMsgVO);

    //내메세지 조회 시 메시지 일괄 읽음처리
    public void isChkUpdate(MessageVO messageVO, HttpServletRequest request);

    //초대메시지 응답 완료 시 메시지 상태 '응답완료' 처리
    public void invResUpdate(MessageVO messageVO, HttpServletRequest request);
}
