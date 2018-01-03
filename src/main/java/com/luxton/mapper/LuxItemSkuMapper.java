package com.luxton.mapper;

import com.luxton.pojo.LuxItemSku;
import com.luxton.pojo.LuxItemSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxItemSkuMapper {
    int countByExample(LuxItemSkuExample example);

    int deleteByExample(LuxItemSkuExample example);

    int deleteByPrimaryKey(Integer skuId);

    int insert(LuxItemSku record);

    int insertSelective(LuxItemSku record);

    List<LuxItemSku> selectByExample(LuxItemSkuExample example);

    LuxItemSku selectByPrimaryKey(Integer skuId);

    int updateByExampleSelective(@Param("record") LuxItemSku record, @Param("example") LuxItemSkuExample example);

    int updateByExample(@Param("record") LuxItemSku record, @Param("example") LuxItemSkuExample example);

    int updateByPrimaryKeySelective(LuxItemSku record);

    int updateByPrimaryKey(LuxItemSku record);
    
    
    LuxItemSku getSkuInfo(@Param("itemId") Integer itemId ,@Param("properties") String properties);
    
    Integer updateSkuQuantity(@Param("itemId") Integer itemId ,@Param("properties") String properties);
    
    
}