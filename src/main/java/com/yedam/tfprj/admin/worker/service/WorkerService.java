package com.yedam.tfprj.admin.worker.service;

import java.util.List;

public interface WorkerService {
    public List<WorkerVO> getWorkerList();
    public List<WorkerVO> getWorkerListStaffCd1();
    public int staffStatusCdUpdate(WorkerVO vo);
}
