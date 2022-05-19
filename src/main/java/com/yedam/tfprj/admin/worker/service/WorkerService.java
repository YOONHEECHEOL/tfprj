package com.yedam.tfprj.admin.worker.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WorkerService {
    public List<Map<String, Object>> getExecl();
    public List<WorkerVO> getWorkerList();
    public List<WorkerVO> getWorkerListStaffCd1();
    public WorkerVO getWorker(String workerId);
    public void admWorkerHrmWrite(WorkerVO vo, MultipartFile file, String birth, HttpServletResponse response) throws IOException, ParseException;
    public int staffStatusCdUpdate(WorkerVO vo);
    public int workerDetailUpdate(String staffStatusCd, String birth, HttpServletResponse response, MultipartFile file, WorkerVO vo) throws IOException, ParseException;
}
