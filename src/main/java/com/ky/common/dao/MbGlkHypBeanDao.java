package com.ky.common.dao;

import com.ky.common.bean.MbGlkHypBean;

public interface MbGlkHypBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(MbGlkHypBean record);

    int insertSelective(MbGlkHypBean record);

    MbGlkHypBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbGlkHypBean record);

    int updateByPrimaryKey(MbGlkHypBean record);
}