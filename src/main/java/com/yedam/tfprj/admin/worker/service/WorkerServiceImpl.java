package com.yedam.tfprj.admin.worker.service;

import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerMapper mapper;

    @Override
    public List<WorkerVO> getWorkerList() {
        return mapper.getWorkerList();
    }

    @Override
    public List<WorkerVO> getWorkerListStaffCd1() {
        return mapper.getWorkerListStaffCd1();
    }


    @Override
    public int staffStatusCdUpdate(WorkerVO vo) {
        return mapper.staffStatusCdUpdate(vo);
    }
}
