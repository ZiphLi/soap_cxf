package com.ky.common.dao;

import com.ky.common.bean.MbFolHypBean;

public interface MbFolHypBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(MbFolHypBean record);

    int insertSelective(MbFolHypBean record);

    MbFolHypBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbFolHypBean record);

    int updateByPrimaryKey(MbFolHypBean record);
}