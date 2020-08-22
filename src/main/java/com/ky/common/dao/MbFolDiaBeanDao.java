package com.ky.common.dao;


import com.ky.common.bean.MbFolDiaBean;

import java.util.List;

public interface MbFolDiaBeanDao {

    int deleteByPrimaryKey(String id);

    int insert(MbFolDiaBean record);

    int insertSelective(MbFolDiaBean record);

    MbFolDiaBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbFolDiaBean record);

    int updateByPrimaryKey(MbFolDiaBean record);

    /**
     * 通过ehr_id查
     *
     * @param ehrId
     * @return
     */
    List<MbFolDiaBean> getDiabeListByEhrId(String ehrId);

}