package com.yedam.tfprj.client.message.service;

import com.yedam.tfprj.admin.todo.Mapper.TodoMapper;
import com.yedam.tfprj.admin.todo.Service.TodoVO;
import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
import com.yedam.tfprj.client.message.mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    MsgMapper msgMapper;

    @Autowired
    WorkerMapper workerMapper;

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<MessageVO> getMessage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("workerId") == null) {
            List<MessageVO> list =  msgMapper.getMessage(request.getSession().getAttribute("memberId").toString());
            return list;
        } else {
            List<MessageVO> list = msgMapper.getMessage(session.getAttribute("workerId").toString());
            return list;
        }
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

    @Override
    public void insertTodoMsg() {
        MessageVO messageVO = new MessageVO();
        List<WorkerVO> list = workerMapper.allWorkerList();
        List<TodoVO> tlist = todoMapper.selectAllCheckList();
        LocalDate now = LocalDate.now();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < tlist.size(); j++) {
                LocalDate ss = toLocalDateInstant(tlist.get(j).getChkMakeDate());
                if (tlist.get(j).getIsChk() == 0 && now.isEqual(ss)) {
                    messageVO.setMemberId(list.get(i).getWorkerId());
                    messageVO.setMessageContents(tlist.get(j).getChkContents() + "가 미완료 상태 입니다.");
                    msgMapper.insertTodoMsg(messageVO);
                }
            }

        }

    }

    // localDate 크기 비교를 위한 변경
    public LocalDate toLocalDateInstant(Date dateToConvert) {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String returnDate = dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().format(formatter);

        return LocalDate.parse(returnDate);
    }
}
