package com.cheng.order.test;

import com.cheng.weixin.rpc.order.entity.OrderInfo;
import com.cheng.weixin.rpc.order.entity.Pay;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcOrderService orderService;

    @Test
    public void test01() {
        //List<DeliveryTime> deliveryTimes = orderService.getAllDeliveryTime();
        //System.out.println(deliveryTimes);
    }

    @Test
    public void test02() {
        List<Pay> pays = orderService.getAllPay();
        System.out.println(pays);
    }

    @Test
    public void test03() throws InvocationTargetException, IllegalAccessException {
        PageInfo<OrderInfo> data = orderService.getOrderInfos("1", 1, 10);
        System.out.println(data);
    }

    @Test
    public void test04() {
        OrderInfo order = new OrderInfo();
        String oid = RandomStringUtils.randomNumeric(8);
        order.setOid(oid);
        order.setAccountId("1");
        orderService.addOrder(order);
    }

}
