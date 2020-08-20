package com.ky.common.dao;

import com.ky.common.bean.OrgBean;

import java.util.List;

public interface OrgBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(OrgBean record);

    int insertSelective(OrgBean record);

    OrgBean selectByPrimaryKey(String id);

    List<OrgBean> selectListByPrimaryKey(String id);


    int updateByPrimaryKeySelective(OrgBean record);

    int updateByPrimaryKey(OrgBean record);
}