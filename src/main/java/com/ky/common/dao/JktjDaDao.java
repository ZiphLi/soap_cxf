package com.ky.common.dao;

import com.ky.common.bean.JktjDaBean;

import java.util.List;

public interface JktjDaDao {
    int deleteByPrimaryKey(String id);

    int insert(JktjDaBean record);

    int insertSelective(JktjDaBean record);

    JktjDaBean selectByPrimaryKey(String id);

    JktjDaBean selectBySfzAndLxdh(String sfz);

    /**
     * 依据机构号获取健康档案
//   * @param orgId 机构号
     * @return getJktjDaForCovertMb
     */
    List<JktjDaBean> getJktjListByOrgIdAndIdNo(String idNo);

    /**
     * 根据身份证获取责任医生
     * @param idNo
     * @return
     */
    JktjDaBean getZrYsAndIdNo(String idNo);
    /**
     * 依据机构号获取健康档案
     * @param orgId 机构号
     * @return getJktjDaForCovertMb
     */
    List<JktjDaBean> getJktjListByOrgId(String orgId);

    /**
     * 根据机构号获取健康档案(自理能力状态)
     * @param orgId
     * @return
     */
    List<JktjDaBean> getZlnlListByOrgId(String orgId);
    /**
     * 依据机构号获取健康档案
     * @param orgId 机构号
     * @return getJktjDaForCovertMb
     */
    List<JktjDaBean> getJktjListForHyByOrgId(String orgId);
    /**
     * 依据机构号获取健康档案
     * @param orgId 机构号
     * @return getJktjDaForCovertMb
     */
    List<JktjDaBean> getJktjListForDaByOrgId(String orgId);

    /**
     * 获取需要转换慢病随访体检记录
     * @param orgId
     * @return
     */
    List<JktjDaBean> getJktjDaForCovertMb(String orgId);
    int updateByPrimaryKeySelective(JktjDaBean record);

    int updateByPrimaryKey(JktjDaBean record);
}