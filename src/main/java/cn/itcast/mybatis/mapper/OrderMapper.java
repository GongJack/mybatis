package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by gh102 on 2017-08-04.
 */
public interface OrderMapper {

    //查询出订单信息，并查询出下单人信息
    public Order findOrderAndUser(@Param("number") String number);

    //查询订单，查询出下单人信息并且查询出订单详情。
    public Order queryOrderWithUserDetail(@Param("number") String number);

    //查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
    public Order queryOrderWithUserDetailAndItem(@Param("number") String number);
}
