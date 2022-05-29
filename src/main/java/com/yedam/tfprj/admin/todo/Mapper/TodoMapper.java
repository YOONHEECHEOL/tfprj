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

    public int chkAddComment(TodoVO vo);
    public int createTodo(TodoVO vo);
    public int ajaxProcessCompleteUpdate(TodoVO vo);
    public int checkBoxAllUpdate(int isChk);
    public int completeAllUpdate(TodoVO vo);
    public int deleteAll();
    public List<TodoVO> selectAllCheckList();
    public int updateMessageYn(String chkNo);
}
