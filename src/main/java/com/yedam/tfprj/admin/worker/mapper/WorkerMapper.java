package com.yedam.tfprj.admin.worker.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper {
    public List<WorkerVO> getList();
}
