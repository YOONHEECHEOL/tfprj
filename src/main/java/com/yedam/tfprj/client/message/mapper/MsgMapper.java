package com.yedam.tfprj.client.message.mapper;

import com.yedam.tfprj.client.message.service.MessageVO;
import com.yedam.tfprj.client.message.service.TeamMsgVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MsgMapper {

    //메시지 조회
    public List<MessageVO> getMessage(String memberId);

    //팀초대 메시지 조회
    public List<TeamMsgVO> getTeamMsg(String memberId, int isMessageCd);

    //팀초대 메시지 전송
    public void insertTeamMsg(MessageVO messageVO);

    //내메세지 조회 시 메시지 일괄 읽음처리
    public void isChkUpdate(MessageVO messageVO);

    //초대메시지 응답 완료 시 메시지 상태 '응답완료' 처리
    public void invResUpdate(MessageVO messageVO);
}
