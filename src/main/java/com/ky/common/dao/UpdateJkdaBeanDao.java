package com.ky.common.dao;

import com.ky.common.bean.UpdateJkdaBean;

import java.util.List;


public interface UpdateJkdaBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(UpdateJkdaBean record);

    int insertSelective(UpdateJkdaBean record);

    UpdateJkdaBean selectByPrimaryKey(String id);

    /**
     * 获取上传有误的体检档案信息
     *
     * @return
     */
    List<UpdateJkdaBean> getAllErrorJkdaList();

    int updateByPrimaryKeySelective(UpdateJkdaBean record);

    int updateByPrimaryKey(UpdateJkdaBean record);
}