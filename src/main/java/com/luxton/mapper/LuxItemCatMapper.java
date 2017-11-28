package com.luxton.mapper;

import com.luxton.pojo.LuxItemCat;
import com.luxton.pojo.LuxItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxItemCatMapper {
    int countByExample(LuxItemCatExample example);

    int deleteByExample(LuxItemCatExample example);

    int deleteByPrimaryKey(Integer catId);

    int insert(LuxItemCat record);

    int insertSelective(LuxItemCat record);

    List<LuxItemCat> selectByExample(LuxItemCatExample example);

    LuxItemCat selectByPrimaryKey(Integer catId);

    int updateByExampleSelective(@Param("record") LuxItemCat record, @Param("example") LuxItemCatExample example);

    int updateByExample(@Param("record") LuxItemCat record, @Param("example") LuxItemCatExample example);

    int updateByPrimaryKeySelective(LuxItemCat record);

    int updateByPrimaryKey(LuxItemCat record);
}