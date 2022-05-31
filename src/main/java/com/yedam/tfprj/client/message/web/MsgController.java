package com.yedam.tfprj.client.message.web;

import com.yedam.tfprj.client.message.mapper.MsgMapper;
import com.yedam.tfprj.client.message.service.*;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MsgController {

    @Autowired
    MsgService msgServiceImpl;
    // 메세지 조회
    @RequestMapping("/msg/msg")
    public List<MessageVO> getMessage(HttpServletRequest request) {
        return msgServiceImpl.getMessage(request);
    }


    // TeamMsg
    @PostMapping("/msg/team")
    public MsgServiceVO getTeamMsg(HttpServletRequest request) {
        return msgServiceImpl.getTeamMsg(request);
    }

    // insert TeamMsg -> Message table
    @PostMapping("/msg/insertTeamMsg")
    public void insertTeamMsg(@RequestBody TeamMsgVO teamMsgVO) {
        msgServiceImpl.insertTeamMsg(teamMsgVO);
    }


    // AttendMsg
    @PostMapping("/msg/attend")
    public MsgServiceVO getAttendMsg(HttpServletRequest request) {
        return msgServiceImpl.getAttendMsg(request);
    }

    // insert AttendMsg -> Message table
    @PostMapping("/msg/insertAttendMsg")
    public void insertAttendMsg(@RequestBody AttendMsgVO attendMsgVO) {
        msgServiceImpl.insertAttendMsg(attendMsgVO);
    }

}
