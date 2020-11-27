package com.wyx.learn.test;

import com.wyx.learn.entity.User;
import com.wyx.learn.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis缓存
 */
public class TestMybatisCache {

  @Test
  public void testCache() throws IOException {
    //1、读取配置文件
    String resource = "resources/MyBatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //2、初始化mybatis，创建SqlSessionFactory类实例
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //3、创建Session实例
    SqlSession session = sqlSessionFactory.openSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);
    // 执行第一次查询
    List<User> users = userMapper.selectUserList();
    for (int i = 0; i < users.size(); i++) {
      System.out.println("users:" + users.get(i));
    }
    System.out.println("=============开始同一个 Sqlsession 的第二次查询============");
    // 同一个 sqlSession 进行第二次查询
    List<User> users2 = userMapper.selectUserList();
    Assert.assertEquals(users, users2);
    for (int i = 0; i < users2.size(); i++) {
      System.out.println("users2:" + users2.get(i));
    }
  }
}
