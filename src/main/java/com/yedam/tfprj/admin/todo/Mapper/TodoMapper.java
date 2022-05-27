package com.yedam.tfprj.admin.todo.Mapper;

import com.yedam.tfprj.admin.todo.Service.CheckVO;
import com.yedam.tfprj.admin.todo.Service.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TodoMapper {
    public List<TodoVO> bringTodayList();
    public int chkNumUpdate(int chkNo, int isChk, String workerId);
    public TodoVO selectCheckListInfo(int chkNo);
    public int todoFileUpload(TodoVO vo);
}
