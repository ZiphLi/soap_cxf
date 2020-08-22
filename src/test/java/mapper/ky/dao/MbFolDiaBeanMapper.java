package com.ky.common.dao;

import com.ky.common.bean.MbFolDiaBean;

public interface MbFolDiaBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(MbFolDiaBean record);

    int insertSelective(MbFolDiaBean record);

    MbFolDiaBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbFolDiaBean record);

    int updateByPrimaryKey(MbFolDiaBean record);
}