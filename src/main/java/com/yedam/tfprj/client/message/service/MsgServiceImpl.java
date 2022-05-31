package com.yedam.tfprj.client.message.service;

import com.yedam.tfprj.client.message.mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService{
    @Autowired
    MsgMapper msgMapper;

    @Override
    public List<MessageVO> getMessage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<MessageVO> list = msgMapper.getMessage(request.getSession().getAttribute("memberId").toString());
        return list;
    }

    @Override
    public MsgServiceVO getTeamMsg(HttpServletRequest request) {

        MsgServiceVO msgServiceVO = new MsgServiceVO();

        msgServiceVO.setTeamMsgVO(msgMapper.getTeamMsg(request.getSession().getAttribute("memberId").toString(), 1006));

        return msgServiceVO;
    }

    @Override
    public void insertTeamMsg(TeamMsgVO teamMsgVO) {

        MessageVO messageVO = new MessageVO();

        // 값을 messageVO에 저장
        messageVO.setMessageContents(teamMsgVO.toString());
        messageVO.setMemberId(teamMsgVO.getMemberId());
        messageVO.setTemp(String.valueOf(teamMsgVO.getTeamId()));

        msgMapper.insertTeamMsg(messageVO);
    }

    @Override
    public MsgServiceVO getAttendMsg(HttpServletRequest request) {
        MsgServiceVO msgServiceVO = new MsgServiceVO();

        msgServiceVO.setAttendMsgVO(msgMapper.getAttendMsg(request.getSession().getAttribute("workerId").toString(), 1001));

        return msgServiceVO;
    }

    @Override
    public void insertAttendMsg(AttendMsgVO attendMsgVO) {
        MessageVO messageVO = new MessageVO();

        // 값을 messageVO에 저장
        messageVO.setMessageContents(attendMsgVO.toString());

        msgMapper.insertAttendMsg(messageVO);
    }


    @Override
    public void isChkUpdate(MessageVO messageVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        messageVO.setMemberId(session.getAttribute("memberId").toString());
        System.out.println(messageVO.getIsChk());
        msgMapper.isChkUpdate(messageVO);
    }

    @Override
    public void invResUpdate(MessageVO messageVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        messageVO.setMemberId(session.getAttribute("memberId").toString());
        msgMapper.invResUpdate(messageVO);
    }
}
