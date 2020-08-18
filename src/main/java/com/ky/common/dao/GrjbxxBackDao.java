package com.ky.common.dao;

import com.ky.common.bean.GrjbxxBackBean;

public interface GrjbxxBackDao {
    int deleteByPrimaryKey(String id);

    int insert(GrjbxxBackBean record);

    int insertSelective(GrjbxxBackBean record);

    GrjbxxBackBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GrjbxxBackBean record);

    int updateByPrimaryKeyWithBLOBs(GrjbxxBackBean record);

    int updateByPrimaryKey(GrjbxxBackBean record);
}