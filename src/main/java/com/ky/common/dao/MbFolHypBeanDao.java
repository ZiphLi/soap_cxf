package com.ky.common.dao;

import com.ky.common.bean.MbFolHypBean;

import java.util.List;

public interface MbFolHypBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(MbFolHypBean record);

    int insertSelective(MbFolHypBean record);

    MbFolHypBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbFolHypBean record);

    int updateByPrimaryKey(MbFolHypBean record);

    /**
     *通过ehr_id查随访
     * @return
     */
    List<MbFolHypBean> getHyperListByEhrId(String ehrId);
}