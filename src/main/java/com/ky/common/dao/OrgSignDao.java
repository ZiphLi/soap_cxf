package com.ky.common.dao;

import com.ky.common.bean.OrgSignBean;

public interface OrgSignDao {
    int deleteByPrimaryKey(String orgId);

    int insert(OrgSignBean record);

    int insertSelective(OrgSignBean record);

    OrgSignBean selectByPrimaryKey(String orgId);

    int updateByPrimaryKeySelective(OrgSignBean record);

    int updateByPrimaryKey(OrgSignBean record);
}