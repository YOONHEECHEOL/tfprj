package com.yedam.tfprj.admin.workerAttendance.service;

import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import com.yedam.tfprj.admin.workerAttendance.mapper.WorkerAttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WorkerAttendanceServiceImpl implements WorkerAttendanceService {

    @Autowired WorkerAttendanceMapper mapper;

    @Override
    public WorkerAttendanceVO getNowWorker() {
        return mapper.getNowWorker();
    }

    @Override
    public int insertAttendance(String workerId) {
        return mapper.insertAttendance(workerId);
    }
}
