package com.yedam.tfprj.admin.worker.mapper;

import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper {
    public List<WorkerVO> getWorkerList();
    public List<WorkerVO> getWorkerListStaffCd1();
    public int staffStatusCdUpdate(WorkerVO vo);
}
