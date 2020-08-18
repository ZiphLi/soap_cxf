package com.ky.common.dao;

import com.ky.common.bean.OrganizationBean;

public interface OrganizationDao {

    int deleteByPrimaryKey(String orgId);

    int insert(OrganizationBean record);

    int insertSelective(OrganizationBean record);

    OrganizationBean selectByPrimaryKey(String orgId);

    /**
     * 依据机构号获取父亲机构对象
     * @param orgId 机构号
     * @return
     */
    OrganizationBean getParentOrgByParentId(String orgId);

    int updateByPrimaryKeySelective(OrganizationBean record);

    int updateByPrimaryKey(OrganizationBean record);
}