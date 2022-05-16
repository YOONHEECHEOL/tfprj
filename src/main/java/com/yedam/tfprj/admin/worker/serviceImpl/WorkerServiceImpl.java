package com.yedam.tfprj.admin.worker.serviceImpl;

import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import com.yedam.tfprj.admin.worker.mapper.WorkerService;
import com.yedam.tfprj.admin.worker.mapper.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerMapper mapper;

    @Override
    public List<WorkerVO> getList() {
        return mapper.getList();
    }
}
