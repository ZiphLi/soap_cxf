package com.ky.common.dao;


import com.ky.common.bean.GrjbxxBean;

import java.util.List;

public interface GrjbxxDao {
    int deleteByPrimaryKey(String id);

    int insert(GrjbxxBean record);

    int insertSelective(GrjbxxBean record);

    GrjbxxBean selectByPrimaryKey(String id);

    /**
     * 依据条码号获取个人基本信息
     * @param tmh
     * @return
     */
    GrjbxxBean getGrjbxxByTmh(String tmh);

    /**
     * 给予机构号获取需要上传的队列
     * @param orgId
     * @return
     */
    List<GrjbxxBean> getGrjbxxListByOrgId(String orgId);

    /**
     *
     * @param orgId
     * @return
     */
    List<GrjbxxBean> getGrjbxxListForGfByOrgId(String orgId);
    int updateByPrimaryKeySelective(GrjbxxBean record);

    int updateByPrimaryKey(GrjbxxBean record);

}