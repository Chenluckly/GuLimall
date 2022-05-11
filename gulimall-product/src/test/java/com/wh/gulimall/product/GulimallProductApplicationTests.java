package com.wh.gulimall.product;



import com.aliyun.oss.*;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wh.gulimall.product.dao.AttrGroupDao;
import com.wh.gulimall.product.dao.SkuSaleAttrValueDao;
import com.wh.gulimall.product.entity.AttrGroupEntity;
import com.wh.gulimall.product.entity.BrandEntity;
import com.wh.gulimall.product.service.AttrGroupService;
import com.wh.gulimall.product.service.BrandService;
import com.wh.gulimall.product.service.SkuSaleAttrValueService;
import com.wh.gulimall.product.vo.SkuItemSaleAttrVo;
import com.wh.gulimall.product.vo.SpuItemAttrGroupVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.templateresource.StringTemplateResource;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {


    @Autowired
    BrandService brandService;

//    @Resource
//    OSSClient ossClient;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;


    @Autowired
    AttrGroupService attrGroupService;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    SkuSaleAttrValueDao skuSaleAttrValueDao;


    @Test
    public void test3(){
        List<SkuItemSaleAttrVo> attrGroupWithAttrsBySpuId = skuSaleAttrValueDao.getSaleAttrsBySpuId(27L);
        System.out.println(attrGroupWithAttrsBySpuId);
    }

    @Test
    public void test(){
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupService.getAttrGroupWithAttrsBySpuId(27L, 225L);
        System.out.println(attrGroupWithAttrsBySpuId);
    }

    @Test
    public void test1(){
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(13L, 225L);
        System.out.println(attrGroupWithAttrsBySpuId);
    }

    @Test
    public void testStringRedis() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        //保存
        ops.set("hello","world_" + UUID.randomUUID().toString());

        //查询
        String hello = ops.get("hello");
        System.out.println("之前保存的数据:"+hello);


    }


    @Test
    public void testRedisson() {
        System.out.println(redissonClient);
    }


