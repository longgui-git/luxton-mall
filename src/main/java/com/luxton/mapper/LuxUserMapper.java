package com.luxton.mapper;

import com.luxton.pojo.LuxUser;
import com.luxton.pojo.LuxUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxUserMapper {
    int countByExample(LuxUserExample example);

    int deleteByExample(LuxUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(LuxUser record);

    int insertSelective(LuxUser record);

    List<LuxUser> selectByExample(LuxUserExample example);

    LuxUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") LuxUser record, @Param("example") LuxUserExample example);

    int updateByExample(@Param("record") LuxUser record, @Param("example") LuxUserExample example);

    int updateByPrimaryKeySelective(LuxUser record);

    int updateByPrimaryKey(LuxUser record);
}