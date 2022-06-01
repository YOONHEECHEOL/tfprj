package com.yedam.tfprj.admin.worker.mapper;

import com.yedam.tfprj.admin.worker.service.WorkerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkerMapper {
    public List<WorkerVO> allWorkerList();
    public List<WorkerVO> getWorkerList();
    public List<Map<String, Object>> getExecl();
    public List<WorkerVO> getWorkerListStaffCd1();
    public WorkerVO getWorker(String workerId);
    public int staffStatusCdUpdate(WorkerVO vo);
    public int workerDetailUpdate(WorkerVO vo);
    public int admWorkerHrmWrite(WorkerVO vo);
    public int signUpUpdate();
    public WorkerVO loginSelect(WorkerVO vo);
    public int updateAllLateAbsence(int isLate, int isAbsence, String workerId);
    public int updateAllPay(String workerId, float allPay);
}
