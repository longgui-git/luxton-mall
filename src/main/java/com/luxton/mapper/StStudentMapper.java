package com.luxton.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luxton.pojo.StStudent;
import com.luxton.pojo.StStudentExample;

public interface StStudentMapper {
    int countByExample(StStudentExample example);

    int deleteByExample(StStudentExample example);

    int deleteByPrimaryKey(Integer stuId);

    int insert(StStudent record);

    int insertSelective(StStudent record);

    List<StStudent> selectByExample(StStudentExample example);

    StStudent selectByPrimaryKey(Integer stuId);

    int updateByExampleSelective(@Param("record") StStudent record, @Param("example") StStudentExample example);

    int updateByExample(@Param("record") StStudent record, @Param("example") StStudentExample example);

    int updateByPrimaryKeySelective(StStudent record);

    int updateByPrimaryKey(StStudent record);
}