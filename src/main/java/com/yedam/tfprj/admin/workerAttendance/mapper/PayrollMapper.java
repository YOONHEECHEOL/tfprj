package com.yedam.tfprj.admin.workerAttendance.mapper;

import com.yedam.tfprj.admin.workerAttendance.service.PayrollVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayrollMapper {
    public int insertPayroll(PayrollVO vo);
    public PayrollVO selectPayroll(PayrollVO vo);

    public PayrollVO selectSumPayroll(PayrollVO vo);
}
