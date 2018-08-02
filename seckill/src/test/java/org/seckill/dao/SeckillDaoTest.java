package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入DAO实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        long id=1000;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * 1000元秒杀iphone6
         * Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         */
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills=seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills){
            System.out.println(seckill);
        }
        /**
         * Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         * Seckill{seckillId=1001, name='500元秒杀ipad2', number=200, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         * Seckill{seckillId=1002, name='300元秒杀mi6', number=300, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         * Seckill{seckillId=1003, name='200元秒杀mimix', number=400, startTime=Tue Jul 31 00:00:00 CST 2018, endTime=Wed Aug 01 00:00:00 CST 2018, createTime=Tue Jul 31 14:23:15 CST 2018}
         */
    }

    @Test
    public void reduceNumber() {
        Date killTime=new Date();
        int updateCount=seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount="+updateCount);
        /**
         * updateCount=0
         */
    }
}