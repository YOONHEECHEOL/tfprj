package com.yedam.tfprj.admin.workerAttendance.mapper;

import com.yedam.tfprj.admin.workerAttendance.service.ReturnVO;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerAttendanceMapper {
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
}
