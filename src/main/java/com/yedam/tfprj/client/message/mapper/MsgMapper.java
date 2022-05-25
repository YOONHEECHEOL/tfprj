package com.yedam.tfprj.client.message.mapper;

import com.yedam.tfprj.client.message.service.MessageVO;
import com.yedam.tfprj.client.message.service.TeamMsgVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MsgMapper {

    @Select("select * from message where member_id = #{memberId}")
    public List<MessageVO> getMessage(String memberId);

    @Select("select * from message where member_id = #{memberId} and is_message_cd = #{isMessageCd}")
    public List<TeamMsgVO> getTeamMsg(String memberId, int isMessageCd);

    @Insert("insert into message values (MESSAGE_SEQ.nextval, sysdate, 0, #{messageContents}, 1006, #{memberId},#{temp})")
    public void insertTeamMsg(MessageVO messageVO);

}
