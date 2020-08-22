package com.ky.common.dao;

import com.ky.common.bean.EhrBean;

public interface EhrBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(EhrBean record);

    int insertSelective(EhrBean record);

    EhrBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EhrBean record);

    int updateByPrimaryKey(EhrBean record);
}