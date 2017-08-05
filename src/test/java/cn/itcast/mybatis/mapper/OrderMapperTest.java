package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by gh102 on 2017-08-04.
 */
public class OrderMapperTest {
    OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test         //查询出订单信息，并查询出下单人信息
    public void findOrderAndUser() throws Exception {
      Order order = orderMapper.findOrderAndUser("20140921001");
        System.out.println(order);
    }

    @Test         //查询订单，查询出下单人信息并且查询出订单详情。
    public void queryOrderWithUserDetail() throws Exception {
      Order order = orderMapper.queryOrderWithUserDetail("20140921001");
      System.out.println(order);
    }

    @Test         //查询订单，查询出下单人信息并且查询出订单详情中的商品数据。。
    public void queryOrderWithUserDetailAndItem() throws Exception {
      Order order = orderMapper.queryOrderWithUserDetailAndItem("20140921001");
      System.out.println(order);
    }

}