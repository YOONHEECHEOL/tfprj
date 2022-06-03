package com.yedam.tfprj.admin.workerAttendance.service;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WorkerAttendanceService {
      public WorkerAttendanceVO getNowWorker();
      public WorkerAttendanceVO getNowWorker2();
      public int insertAttendance(String workerId);

      public WorkerAttendanceVO getWorkerInOutTime(String workerId);
      public int updateIslate(String workerId);
      public int updateIsAbsence(String workerId);
      public WorkerAttendanceVO getSecond(String workerId);
      public int updateQuit(String workerId);
      public WorkerAttendanceVO getPercent(String workerId);
      public List<WorkerAttendanceVO> selectQuitTime(String workerId);
      public List<WorkerAttendanceVO> selectStaffInOutWeek();
      public WorkerAttendanceVO allLate(String workerId);
      public WorkerAttendanceVO weekLate(String workerId);
      public WorkerAttendanceVO monthLate(String workerId);
      public WorkerAttendanceVO allAbsence(String workerId);
      public List<WorkerAttendanceVO> selectNotInWorker(String dd, String ff);
      public int insertNotInWorker(String workerId, String dated);
      public List<WorkerAttendanceVO> payCalc(String workerId);

      public List<WorkerAttendanceVO> lastMonthPay(String workerId, String firstDate, String lastDate);

      public int insertPayroll(PayrollVO vo);
      public PayrollVO selectPayroll(PayrollVO vo);

      public PayrollVO selectSumPayroll(PayrollVO vo);
   }
