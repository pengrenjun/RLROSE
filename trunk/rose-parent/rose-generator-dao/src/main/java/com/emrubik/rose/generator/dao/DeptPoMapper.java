package com.emrubik.rose.generator.dao;

import com.emrubik.rose.generator.dao.bean.DeptPo;
import com.emrubik.rose.generator.dao.bean.DeptPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int countByExample(DeptPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int deleteByExample(DeptPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int insert(DeptPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int insertSelective(DeptPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    List<DeptPo> selectByExample(DeptPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DeptPo record, @Param("example") DeptPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_DEPT
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DeptPo record, @Param("example") DeptPoExample example);
}