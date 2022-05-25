package com.yedam.tfprj.admin.workerAttendance.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WorkerAttendanceService {
      public WorkerAttendanceVO getNowWorker();
      public int insertAttendance(String workerId);

      public WorkerAttendanceVO getWorkerInOutTime(String workerId);
      public int updateIslate(String workerId);
      public int updateIsAbsence(String workerId);
      public WorkerAttendanceVO getSecond(String workerId);
      public int updateQuit(String workerId);
      public WorkerAttendanceVO getPercent(String workerId);
      public List<WorkerAttendanceVO> selectQuitTime(String workerId);
   }
