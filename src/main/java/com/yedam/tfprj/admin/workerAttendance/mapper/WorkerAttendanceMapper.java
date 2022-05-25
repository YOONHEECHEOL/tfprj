package com.yedam.tfprj.admin.workerAttendance.mapper;

import com.yedam.tfprj.admin.workerAttendance.service.ReturnVO;
import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerAttendanceMapper {
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
