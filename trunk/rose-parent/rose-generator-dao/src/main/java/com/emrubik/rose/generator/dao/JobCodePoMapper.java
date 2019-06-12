package com.emrubik.rose.generator.dao;

import com.emrubik.rose.generator.dao.bean.JobCodePo;
import com.emrubik.rose.generator.dao.bean.JobCodePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobCodePoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int countByExample(JobCodePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int deleteByExample(JobCodePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int insert(JobCodePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int insertSelective(JobCodePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    List<JobCodePo> selectByExample(JobCodePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") JobCodePo record, @Param("example") JobCodePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PS_I_JOBCODE
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") JobCodePo record, @Param("example") JobCodePoExample example);
}