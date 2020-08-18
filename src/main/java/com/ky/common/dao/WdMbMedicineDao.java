package com.ky.common.dao;

import com.ky.common.bean.WdMbMedicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdMbMedicineDao {
    int deleteByPrimaryKey(String id);

    int insert(WdMbMedicine record);

    int insertSelective(WdMbMedicine record);

    /**
     * 删除具体用药类型
     * @param sfId 随访ID
     * @param folType 随访类型   GXY   TNB
     * @param medType 用药类型   NOW（当前用药）
     *                           ADJUST（调整用药）
     * @return
     */
    int deleteByMedBySfIdT(@Param("sfId") String sfId,
                           @Param("folType") String folType,
                           @Param("medType") String medType);
    /**
     * 删除具体用药类型
     * @param sfId 随访ID
     * @return
     */
    int deleteByMedBySfId(String sfId);
    /**
     *
     * @param sfId
     * @return
     */
    List<WdMbMedicine> getMedListByParam(@Param("sfId") String sfId,
                                         @Param("folType") String folType,
                                         @Param("medType") String medType);

    WdMbMedicine selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WdMbMedicine record);

    int updateByPrimaryKey(WdMbMedicine record);
}