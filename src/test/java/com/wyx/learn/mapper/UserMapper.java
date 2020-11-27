package com.wyx.learn.mapper;

import com.wyx.learn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    User save(User user);

    User getUser(Integer id);

    List<User> selectUserList();

    /**
     *  多个参数 map方式
     *
     * @param params
     * @return
     */
      List<User> selectBetweenCreatedTime(Map<String, Object> params);

    /**
     * 多个参数，注解方式
     *
     * @return
     */
      List<User> selectBetweenCreatedTimeAnno(@Param("startTime") Date pbTime, @Param("endTime")Date peTime);

    /**
     * 一对多查询
     *
     * @param id
     * @return
     */
    User getUserSalary(Integer id);
}
