package com.emrubik.rose.modules.emailUtils.mapper;

import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description TODO
 * @Date 2019/4/17 0017 上午 11:18
 * @Created by Pengrenjun
 */
@Mapper
public interface UecPmsMailMapper {

    @Select("select bs_danju.nextval from dual")
    int getOidNextSeq();
}
