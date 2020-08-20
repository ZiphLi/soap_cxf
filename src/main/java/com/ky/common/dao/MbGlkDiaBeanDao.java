package com.ky.common.dao;

import com.ky.common.bean.MbGlkDiaBean;

public interface MbGlkDiaBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(MbGlkDiaBean record);

    int insertSelective(MbGlkDiaBean record);

    MbGlkDiaBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbGlkDiaBean record);

    int updateByPrimaryKey(MbGlkDiaBean record);
}