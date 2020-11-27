/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.wyx.learn.test;

import com.wyx.learn.entity.User;
import com.wyx.learn.entity.UserSalary;
import com.wyx.learn.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 1.通过 Resources 工具类读取 mybatis-config.xml， 存入 Reader；
 * 	mybatis解析配置文件的本质就是获得Configuration对象
 * 2.SqlSessionFactoryBuilder 使用上一步获得的 reader 创建 SqlSessionFactory 对象;
 * 3.通过 sqlSessionFactory 对象获得 SqlSession;
 * 4.SqlSession对象通过 *Mapper 方法找到对应的 SQL 语句， 执行 SQL 查询。
 * 5.底层通过 JDBC 查询后获得 ResultSet, 对每一条记录， 根据resultMap的映射结果映射到 Student 中， 返回 List。
 * 6.最后记得关闭 SqlSession
 *
 */
public class TestGetUserSalary {

    @Test
    public void testGetUserSalary() throws IOException {
        //1、读取配置文件
        String resource = "resources/MyBatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、创建Session实例
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserSalary(1);
        System.out.println(user.getUserName() +  " " + user.getDeptment());
        List<UserSalary> salaryList = user.getSalaryList();
        for (int i = 0; i < salaryList.size(); i++) {
          System.out.println(salaryList.get(i).getMonth() +  "月:工资" + salaryList.get(i).getSalary());
        }
    }

}
