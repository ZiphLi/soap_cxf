package com.ky.common.dao;

import com.ky.common.bean.OrgBean;

public interface OrgBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgBean record);

    int insertSelective(OrgBean record);

    OrgBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgBean record);

    int updateByPrimaryKey(OrgBean record);
}