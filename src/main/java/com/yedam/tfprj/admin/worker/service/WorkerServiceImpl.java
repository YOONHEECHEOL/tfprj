package com.yedam.tfprj.admin.worker.service;

import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
public class WorkerServiceImpl implements WorkerService, UserDetailsService {
    @Autowired
    WorkerMapper mapper;

    @Override
    public List<WorkerVO> allWorkerList() {
        return mapper.allWorkerList();
    }

    @Override
    public List<Map<String, Object>> getExecl() {
        return mapper.getExecl();
    }

    @Override
    public List<WorkerVO> getWorkerList() {
        return mapper.getWorkerList();
    }

    @Override
    public List<WorkerVO> getWorkerListStaffCd1() {
        return mapper.getWorkerListStaffCd1();
    }

    @Override
    public WorkerVO getWorker(String workerId) {
        return mapper.getWorker(workerId);
    }


    @Override
    public void admWorkerHrmWrite(WorkerVO vo, MultipartFile file, String birth, HttpServletResponse response) throws IOException {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\adm";

        System.out.println("vo = " + vo);

        if(file != null && file.getSize() > 0) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            File saveFile = new File(projectPath, fileName);

            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            vo.setOriginalFileName(file.getOriginalFilename());
            vo.setFileName(fileName);
            vo.setFilePath("/images/adm/" + fileName);
        }
        System.out.println("vo = " + vo);
        PrintWriter out = response.getWriter();
        out.println("<script>window.close()</script> ");
        // 자바스크립트에서 window.close()를 사용할 경우 데이터를 submit 하기전에 window.close()가 실행되기 때문에,
        // 컨트롤러에서 스크립트 코드 사용
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));

        mapper.admWorkerHrmWrite(vo);
    }


    @Override
    public int staffStatusCdUpdate(WorkerVO vo) {
        return mapper.staffStatusCdUpdate(vo);
    }

    @Override
    public int workerDetailUpdate(String staffStatusCd, String birth, HttpServletResponse response, MultipartFile file, WorkerVO vo) throws IOException, ParseException {

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\adm";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        vo.setOriginalFileName(file.getOriginalFilename());
        vo.setFileName(fileName);
        vo.setFilePath("/images/adm/" + fileName);

        //DatePicker에서 String 타입으로 값을 던지기 때문에 java단에서 Date 타입으로 변경 후 vo에 담고 update.
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        // 문자열 -> Date
        Date date = formatter.parse(birth);
        vo.setBirth(date);
        vo.setStaffStatusCd(Integer.parseInt(staffStatusCd));
        PrintWriter out = response.getWriter();
        out.println("<script>window.close()</script>");
        // 자바스크립트에서 window.close()를 사용할 경우 데이터를 submit 하기전에 window.close()가 실행되기 때문에,
        // 컨트롤러에서 스크립트 코드 사용

        return mapper.workerDetailUpdate(vo);
    }

    @Override
    public int signUpUpdate() {
        return mapper.signUpUpdate();
    }

    @Override
    public WorkerVO loginSelect(WorkerVO vo) {
        return mapper.loginSelect(vo);
    }

    @Override
    public int updateAllLateAbsence(int isLate, int isAbsence, String workerId) {
        return mapper.updateAllLateAbsence(isLate, isAbsence, workerId);
    }

    @Override
    public int updateLastMonthPay(String workerId, float lastMonthPay) {
        return mapper.updateLastMonthPay(workerId, lastMonthPay);
    }

    @Override
    public int updateSumPay(String workerId, float allPay) {
        return mapper.updateSumPay(workerId, allPay);
    }

    @Override
    public WorkerVO isIdCheck(String workerId) {
        return mapper.isIdCheck(workerId);
    }

    @Override
    public UserDetails loadUserByUsername(String workerId) throws UsernameNotFoundException {
        WorkerVO vo = mapper.getWorker(workerId);
        vo.setWorkerAuth("ROLE_ADMIN");
        if (vo == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return vo;
    }
}
