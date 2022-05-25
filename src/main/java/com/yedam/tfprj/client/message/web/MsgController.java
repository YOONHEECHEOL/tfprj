package com.yedam.tfprj.client.message.web;

import com.yedam.tfprj.client.message.mapper.MsgMapper;
import com.yedam.tfprj.client.message.service.MessageVO;
import com.yedam.tfprj.client.message.service.MsgServiceVO;
import com.yedam.tfprj.client.message.service.TeamMsgVO;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MsgController {

    @Autowired
    MsgMapper mapper;

    @RequestMapping("/msg/msg")
    public List<MessageVO> getMessage(HttpServletRequest request) {

        List<MessageVO> list = new ArrayList<>();

        list = mapper.getMessage(request.getSession().getAttribute("memberId").toString());

        return list;
    }


    // TeamMsg
    @PostMapping("/msg/team")
    public MsgServiceVO getTeamMsg(HttpServletRequest request) {

        MsgServiceVO msgServiceVO = new MsgServiceVO();

        TeamMsgVO teamMsgVO = new TeamMsgVO();

        msgServiceVO.setTeamMsgVO(mapper.getTeamMsg(request.getSession().getAttribute("memberId").toString(), 1006));


        return msgServiceVO;

    }

    // insert TeamMsg -> Message table
    @PostMapping("/msg/insertTeamMsg")
    public void insertTeamMsg(@RequestBody TeamMsgVO teamMsgVO, HttpServletRequest request) {

        System.out.println("teamMsgVO = " + teamMsgVO);

        MessageVO messageVO = new MessageVO();

        // 값을 messageVO에 저장
        messageVO.setMessageContents(teamMsgVO.toString());
        messageVO.setMemberId(teamMsgVO.getMemberId());
        messageVO.setTemp(String.valueOf(teamMsgVO.getTeamId()));

        mapper.insertTeamMsg(messageVO);

    }

}
