package com.yedam.tfprj.admin.workerAttendance.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WorkerAttendanceService {
      public WorkerAttendanceVO getNowWorker();
   }
