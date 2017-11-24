package com.luxton.mapper;

import com.luxton.pojo.LuxRegisterCode;
import com.luxton.pojo.LuxRegisterCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxRegisterCodeMapper {
    int countByExample(LuxRegisterCodeExample example);

    int deleteByExample(LuxRegisterCodeExample example);

    int deleteByPrimaryKey(String registerCode);

    int insert(LuxRegisterCode record);

    int insertSelective(LuxRegisterCode record);

    List<LuxRegisterCode> selectByExample(LuxRegisterCodeExample example);

    LuxRegisterCode selectByPrimaryKey(String registerCode);

    int updateByExampleSelective(@Param("record") LuxRegisterCode record, @Param("example") LuxRegisterCodeExample example);

    int updateByExample(@Param("record") LuxRegisterCode record, @Param("example") LuxRegisterCodeExample example);

    int updateByPrimaryKeySelective(LuxRegisterCode record);

    int updateByPrimaryKey(LuxRegisterCode record);
}