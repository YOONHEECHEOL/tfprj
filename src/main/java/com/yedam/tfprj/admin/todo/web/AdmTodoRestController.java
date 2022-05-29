package com.yedam.tfprj.admin.todo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.todo.Service.TodoService;
import com.yedam.tfprj.admin.todo.Service.TodoVO;
import com.yedam.tfprj.admin.todo.Service.CheckVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping("/adm/chkAddComment")
    public TodoVO chkAddComment(TodoVO vo){
        service.chkAddComment(vo);
        return vo;
    }

    @RequestMapping("/adm/createTodo")
    public List<TodoVO> createTodo(TodoVO vo){
        service.createTodo(vo);
        return service.bringTodayList();
    }

    @RequestMapping("/adm/ajaxProcessCompleteUpdate")
    public TodoVO ajaxProcessCompleteUpdate(TodoVO vo){
        service.ajaxProcessCompleteUpdate(vo);
        return vo;
    }

    @RequestMapping("/adm/checkBoxAllUpdate")
    public void checkBoxAllUpdate(@RequestParam String jsonData, @RequestParam int isChk) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        TodoVO[] arr = objectMapper.readValue(jsonData, TodoVO[].class);

        service.checkBoxAllUpdate(isChk);
    }

    @RequestMapping("/adm/completeAllUpdate")
    public void completeAllUpdate(TodoVO vo){
        service.completeAllUpdate(vo);
    }

    @RequestMapping("/adm/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }

    @RequestMapping("/adm/selectAllCheckList")
    public List<TodoVO> selectAllCheckList(){
        return service.selectAllCheckList();
    }

    @RequestMapping("/adm/dateChangeMessage")
    public void dateChangeMessage(@RequestParam(value="arr[]") List<String> arr) {
        for(int i=0; i<arr.size(); i++){
            //메시지YN 1로 업데이트 후,
            service.updateMessageYn(arr.get(i));
            //메시지 테이블에 insert
        }

        System.out.println("배열" + arr.get(0));
    }
}
