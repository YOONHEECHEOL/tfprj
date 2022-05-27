package com.yedam.tfprj.admin.todo.web;

import com.yedam.tfprj.admin.todo.Service.TodoService;
import com.yedam.tfprj.admin.todo.Service.TodoVO;
import com.yedam.tfprj.admin.todo.Service.CheckVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdmTodoRestController {
    @Autowired
    TodoService service;

    @RequestMapping("/adm/bringTodayList")
    public List<TodoVO> bringTodayList(){
        return service.bringTodayList();
    }

    @RequestMapping("/adm/chkNumUpdate")
    public CheckVO chkNumUpdate(int chkNo, int isChk, String workerId){
        if(isChk == 0) {
            service.chkNumUpdate(chkNo, isChk, null);
        }else{
            service.chkNumUpdate(chkNo, isChk, workerId);
        }

        CheckVO vo = new CheckVO();
        vo.setChkNo(chkNo);
        vo.setIsChk(isChk);

        return vo;
    }

    @RequestMapping("/adm/selectCheckListInfo")
    public TodoVO selectCheckListInfo(int chkNo){
        System.out.println("체크번호 " + service.selectCheckListInfo(chkNo));
        return service.selectCheckListInfo(chkNo);
    }

}
