package com.ky.common.dao;

import com.ky.common.bean.MbGlkHypBean;

import java.util.List;

public interface MbGlkHypBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(MbGlkHypBean record);

    int insertSelective(MbGlkHypBean record);

    MbGlkHypBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MbGlkHypBean record);

    int updateByPrimaryKey(MbGlkHypBean record);

    /**
     * 根据身份证查高血压管理卡队列(可能重复)
     * @param sfz
     * @return
     */
    List<MbGlkHypBean> selectBySfz(String sfz);
}