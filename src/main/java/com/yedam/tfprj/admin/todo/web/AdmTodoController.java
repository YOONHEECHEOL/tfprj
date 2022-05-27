package com.yedam.tfprj.admin.todo.web;

import com.yedam.tfprj.admin.todo.Service.TodoService;
import com.yedam.tfprj.admin.todo.Service.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdmTodoController {
    @Autowired
    TodoService service;
    @RequestMapping("/adm/todo")
    public String admTodoManage(){
        return "admin/todo/todo";
    }

    @RequestMapping("/adm/todoFileUpload")
    public String todoFileUpload(TodoVO vo, MultipartFile file){
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\adm";

        System.out.println("vo는 = " + vo);
        System.out.println("파일" + file);
        if(file != null && file.getSize() > 0) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            File saveFile = new File(projectPath, fileName);

            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//          vo.setOriginalFileName(file.getOriginalFilename());
            vo.setChkPicFileName(fileName);
            vo.setChkPicFilePath("/images/adm/" + fileName);
        }
        service.todoFileUpload(vo);

        return "redirect:/adm/todo";
    }
}
