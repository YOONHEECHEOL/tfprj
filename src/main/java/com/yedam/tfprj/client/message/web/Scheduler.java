package com.yedam.tfprj.client.message.web;

import com.yedam.tfprj.client.message.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    MsgService msgServiceImpl;
    @Scheduled(cron = "0 50 12 * * *")
    public void scheduleInsertTodoMsg() {
        System.out.println("Admin Message Count Start");
        msgServiceImpl.insertTodoMsg();
    }

}
