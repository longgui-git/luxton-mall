package com.luxton.mapper;

import com.luxton.pojo.LuxSupplier;
import com.luxton.pojo.LuxSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxSupplierMapper {
    int countByExample(LuxSupplierExample example);

    int deleteByExample(LuxSupplierExample example);

    int deleteByPrimaryKey(Integer supplierId);

    int insert(LuxSupplier record);

    int insertSelective(LuxSupplier record);

    List<LuxSupplier> selectByExample(LuxSupplierExample example);

    LuxSupplier selectByPrimaryKey(Integer supplierId);

    int updateByExampleSelective(@Param("record") LuxSupplier record, @Param("example") LuxSupplierExample example);

    int updateByExample(@Param("record") LuxSupplier record, @Param("example") LuxSupplierExample example);

    int updateByPrimaryKeySelective(LuxSupplier record);

    int updateByPrimaryKey(LuxSupplier record);
    
    
    List<LuxSupplier> getIndexSupplier();
}