package com.yedam.tfprj.admin.todo.Service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    public List<TodoVO> bringTodayList();
    public int chkNumUpdate(int chkNo, int isChk, String workerId);

    public TodoVO selectCheckListInfo(int chkNo);
    public int todoFileUpload(TodoVO vo);
}
