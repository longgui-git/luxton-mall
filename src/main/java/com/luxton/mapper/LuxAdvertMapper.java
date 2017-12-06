package com.luxton.mapper;

import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertExample;
import com.luxton.pojo.common.AdvertWithItem;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxAdvertMapper {
    int countByExample(LuxAdvertExample example);

    int deleteByExample(LuxAdvertExample example);

    int deleteByPrimaryKey(Integer advertId);

    int insert(LuxAdvert record);

    int insertSelective(LuxAdvert record);

    List<LuxAdvert> selectByExample(LuxAdvertExample example);

    LuxAdvert selectByPrimaryKey(Integer advertId);

    int updateByExampleSelective(@Param("record") LuxAdvert record, @Param("example") LuxAdvertExample example);

    int updateByExample(@Param("record") LuxAdvert record, @Param("example") LuxAdvertExample example);

    int updateByPrimaryKeySelective(LuxAdvert record);

    int updateByPrimaryKey(LuxAdvert record);
    
    
    List<AdvertWithItem> getAdvertListByType(@Param("typeId") Integer typeId);
    
    List<AdvertWithItem> getAdvertList();
}