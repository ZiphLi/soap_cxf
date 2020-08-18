package com.ky.common.dao;

import com.ky.common.bean.JktjBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JktjDao {
    int deleteByPrimaryKey(String id);

    int insert(JktjBean record);

    int insertSelective(JktjBean record);

    JktjBean selectByPrimaryKey(String id);

    /**
     * 根据条码号及机构号获取对应的体检信息
     * @param orgI
     * @param tmh
     * @return
     */
    JktjBean getJktjByTmhAndOrgId(@Param("orgId") String orgI,
                                  @Param("tmh") String tmh);
    List<JktjBean> getJktjByTAndOrgId(@Param("orgId") String orgId);
    int updateByPrimaryKeySelective(JktjBean record);

    int updateByPrimaryKey(JktjBean record);
}