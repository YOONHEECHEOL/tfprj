package com.yedam.tfprj.admin.todo.Service;

import com.yedam.tfprj.admin.todo.Mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    TodoMapper mapper;

    @Override
    public List<TodoVO> bringTodayList() {
        return mapper.bringTodayList();
    }

    @Override
    public int chkNumUpdate(int chkNo, int isChk, String workerId) {
        return mapper.chkNumUpdate(chkNo, isChk, workerId);
    }

    @Override
    public TodoVO selectCheckListInfo(int chkNo) {
        return mapper.selectCheckListInfo(chkNo);
    }

    @Override
    public int todoFileUpload(TodoVO vo) {
        return mapper.todoFileUpload(vo);
    }

    @Override
    public int chkAddComment(TodoVO vo) {
        return mapper.chkAddComment(vo);
    }

    @Override
    public int createTodo(TodoVO vo) {
        return mapper.createTodo(vo);
    }

    @Override
    public int ajaxProcessCompleteUpdate(TodoVO vo) {
        return mapper.ajaxProcessCompleteUpdate(vo);
    }

    @Override
    public int checkBoxAllUpdate(int isChk) {
        return mapper.checkBoxAllUpdate(isChk);
    }

    @Override
    public int completeAllUpdate(TodoVO vo) {
        return mapper.completeAllUpdate(vo);
    }

    @Override
    public int deleteAll() {
        return mapper.deleteAll();
    }

    @Override
    public List<TodoVO> selectAllCheckList() {
        return mapper.selectAllCheckList();
    }

    @Override
    public int updateMessageYn(String chkNo) {
        return mapper.updateMessageYn(chkNo);
    }


}
