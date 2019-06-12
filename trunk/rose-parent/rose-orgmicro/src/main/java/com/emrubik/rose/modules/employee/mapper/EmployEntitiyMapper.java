package com.emrubik.rose.modules.employee.mapper;

import com.emrubik.entity.employee.bean.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 导入Rose 人员数据查询接口
 * @Date 2019/3/21 0021 上午 11:35
 * @Created by Pengrenjun
 */
@Mapper
public interface EmployEntitiyMapper {

    List<EmployeeEntity> getAllEmployees();
}
