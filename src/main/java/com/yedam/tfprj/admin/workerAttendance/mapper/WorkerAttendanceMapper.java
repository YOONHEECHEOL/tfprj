package com.yedam.tfprj.admin.workerAttendance.mapper;

import com.yedam.tfprj.admin.workerAttendance.service.WorkerAttendanceVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerAttendanceMapper {
    public WorkerAttendanceVO getNowWorker();

}
