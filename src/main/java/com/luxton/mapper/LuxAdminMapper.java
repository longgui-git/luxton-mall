package com.luxton.mapper;

import com.luxton.pojo.LuxAdmin;
import com.luxton.pojo.LuxAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxAdminMapper {
    int countByExample(LuxAdminExample example);

    int deleteByExample(LuxAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LuxAdmin record);

    int insertSelective(LuxAdmin record);

    List<LuxAdmin> selectByExample(LuxAdminExample example);

    LuxAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LuxAdmin record, @Param("example") LuxAdminExample example);

    int updateByExample(@Param("record") LuxAdmin record, @Param("example") LuxAdminExample example);

    int updateByPrimaryKeySelective(LuxAdmin record);

    int updateByPrimaryKey(LuxAdmin record);
}