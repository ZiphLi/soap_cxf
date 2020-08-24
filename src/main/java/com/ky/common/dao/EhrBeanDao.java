package com.ky.common.dao;

import com.ky.common.bean.EhrBean;

import java.util.List;

public interface EhrBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(EhrBean record);

    int insertSelective(EhrBean record);

    EhrBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EhrBean record);

    int updateByPrimaryKey(EhrBean record);

    /**
     * 通过gwDah查
     *
     * @param gw_dah
     * @return
     */
    List<EhrBean> selectByGwDah(String gw_dah);
}