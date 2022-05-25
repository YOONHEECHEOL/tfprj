package com.yedam.tfprj.admin.common.service;

import com.yedam.tfprj.admin.common.mapper.CommonMapper;
import com.yedam.tfprj.admin.workerAttendance.mapper.WorkerAttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper mapper;


}
