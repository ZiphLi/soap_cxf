package com.ky.common.dao;


import com.ky.common.bean.WdEhrBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdEhrBeanDao {
    int deleteByPrimaryKey(String id);

    int insert(WdEhrBean record);

    int insertSelective(WdEhrBean record);

    /**
     *
     * @param sfz
     * @param orgId
     * @return
     */
    WdEhrBean getEhrByParam(@Param("sfz") String sfz, @Param("orgId") String orgId);
    /**
     * 依据机构Id号获取所有的管理人员档案信息
     * @param orgId
     * @return
     */
    List<WdEhrBean> getAllEhrByOrgId(String orgId);

    WdEhrBean selectByPrimaryKey(String id);

    /**
     * 根据身份证查(可能重复)
     * @param sfz
     * @return
     */
    List<WdEhrBean> selectBySfz(String sfz);

    int updateByPrimaryKeySelective(WdEhrBean record);

    int updateByPrimaryKey(WdEhrBean record);
}