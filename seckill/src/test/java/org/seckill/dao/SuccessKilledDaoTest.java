package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id=1001L;
        long phone=13502181181L;
        int insertCount=successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("insertCount="+insertCount);
        /**
         * 第一次：insertCount=1
         * 第二次：insertCount=0
         */
    }

    @Test
    public void queryByIdWithSeckill() {
        long id=1001L;
        long phone=13502181181L;
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
        /**
         * SuccessKilled{seckillId=1000, userPhone=13502181181, state=-1, createTime=Wed Aug 01 09:51:21 CST 2018}
         * Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         */
    }
}