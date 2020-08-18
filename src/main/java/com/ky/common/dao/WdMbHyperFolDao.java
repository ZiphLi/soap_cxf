package com.ky.common.dao;


import com.ky.common.bean.WdMbHyperFol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdMbHyperFolDao {

    int deleteByPrimaryKey(String uuid);

    int insert(WdMbHyperFol record);

    int insertSelective(WdMbHyperFol record);

    WdMbHyperFol selectByPrimaryKey(String uuid);

    /**
     * 依据数据来源、身份证号、机构获取最新的随访数据
     * @param orgId
     * @param idNo
     * @param orgin
     * @return
     */
    WdMbHyperFol getHyperByOrginAndParam(@Param("orgId") String orgId, @Param("idNo") String idNo, @Param("orgin") String orgin);

    /**
     * 依据月份获取个人的随访信息
     * @param orgId
     * @param sfz
     * @param month
     * @return
     */
    List<WdMbHyperFol> getHyperListByMonth(@Param("orgId") String orgId, @Param("idNo") String sfz, @Param("month") int month);

    /**
     * 依据机构号获取随访队列
     * @param orgId
     * @return
     */
    List<WdMbHyperFol> getAllHyperPeoByOrgId(@Param("orgId") String orgId);
    /**
     * 依据机构号获取随访队列
     * @param orgId
     * @return
     */
    WdMbHyperFol getLastHyperFol(@Param("orgId") String orgId, @Param("idNo") String idNo);
    /**
     * 依据机构及身份证号获取该人所有的随访记录
     * @param orgId  机构ID号
     * @param sfz    身份证号
     * @return
     */
    List<WdMbHyperFol> getHyperListBySfzAndOrgId(@Param("orgId") String orgId, @Param("sfz") String sfz);
    /**
     * 依据机构及身份证号获取该人所有的随访记录
     * @param orgId  机构ID号
     * @param sfz    身份证号
     * @return
     */
    List<WdMbHyperFol> getHyperListBySfzAndOrgIdForTrue(@Param("orgId") String orgId, @Param("sfz") String sfz);

    /**
     * 根据机构号查询高血压随访
     * @param orgId
     * @return
     */
    List<WdMbHyperFol> getFolForUpGw(@Param("orgId") String orgId);
    /**
     * 获取未随访人员名单
     * @return
     */
    List<WdMbHyperFol> getNoFolDetail();
    /**
     * 根据机构ID号获取该机构的所有的慢病随访信息
     * @param orgId
     * @return
     */
    List<WdMbHyperFol> getAllHyperFolByOrgId(String orgId);
    /**
     * 根据机构ID号获取该机构的所有的慢病随访信息
     * @param orgId
     * @return
     */
    List<WdMbHyperFol> getHyperFolByOrgId(String orgId);
    /**
     * 依据条件获取
     * @param idNo
     * @param orgId
     * @param sfrq
     * @return
     */
    WdMbHyperFol getHyperFolByParam(@Param("idNo") String idNo, @Param("orgId") String orgId, @Param("sfrq") String sfrq);

    /**
     * 依据 身份证、机构及当前随访日期查询之前最近的一条随访记录
     * @param idNo  身份证号
     * @param orgId 所属机构
     * @param sfrq  当前随访日期
     * @return
     */
    WdMbHyperFol getLastSfBeforeTime(@Param("idNo") String idNo, @Param("orgId") String orgId, @Param("sfrq") String sfrq);
    /**
     * 依据 身份证、机构及当前随访日期查询之前最近的一条随访记录
     * @param idNo  身份证号
     * @param orgId 所属机构
     * @return
     */
    WdMbHyperFol getLastSf(@Param("idNo") String idNo, @Param("orgId") String orgId);

    /**
     * 依据 身份证、机构及当前随访日期查询之前最近的一条随访记录
     * @param idNo  身份证号
     * @param orgId 所属机构
     * @param sfrq  当前随访日期
     * @return
     */
    WdMbHyperFol getNewSfAfterTime(@Param("idNo") String idNo, @Param("orgId") String orgId, @Param("sfrq") String sfrq);

    int updateByPrimaryKeySelective(WdMbHyperFol record);

    int updateByPrimaryKey(WdMbHyperFol record);
}