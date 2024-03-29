package com.emrubik.rosemail.generator.dao;

import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPo;
import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsEmailOidPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int countByExample(PmsEmailOidPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int deleteByExample(PmsEmailOidPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int insert(PmsEmailOidPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int insertSelective(PmsEmailOidPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    List<PmsEmailOidPo> selectByExample(PmsEmailOidPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    PmsEmailOidPo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PmsEmailOidPo record, @Param("example") PmsEmailOidPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PmsEmailOidPo record, @Param("example") PmsEmailOidPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PmsEmailOidPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UEC_PMS_EMAIL_OID
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PmsEmailOidPo record);
}