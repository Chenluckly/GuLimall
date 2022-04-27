package com.wh.gulimall.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.wh.common.utils.R;
import com.wh.gulimall.product.entity.SkuImagesEntity;
import com.wh.gulimall.product.entity.SpuInfoDescEntity;
import com.wh.gulimall.product.service.*;
import com.wh.gulimall.product.vo.SeckillSkuVo;
import com.wh.gulimall.product.vo.SkuItemSaleAttrVo;
import com.wh.gulimall.product.vo.SkuItemVo;
import com.wh.gulimall.product.vo.SpuItemAttrGroupVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.common.utils.PageUtils;
import com.wh.common.utils.Query;

import com.wh.gulimall.product.dao.SkuInfoDao;
import com.wh.gulimall.product.entity.SkuInfoEntity;

import javax.annotation.Resource;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {


    @Autowired
    private SkuImagesService imagesService;
    @Autowired
    private SpuInfoDescService spuInfoDescService;
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;
    @Resource
    private ThreadPoolExecutor executor;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfoEntity) {
        this.baseMapper.insert(skuInfoEntity);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SkuInfoEntity> queryWrapper = new QueryWrapper<>();

        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key) && !"0".equalsIgnoreCase(key)) {
            queryWrapper.and((wrapper) -> {
                wrapper.eq("sku_id",key).or().like("sku_name",key);
            });
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.eq("catalog_id",catelogId);
        }

        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !"0".equalsIgnoreCase(brandId)) {
            queryWrapper.eq("brand_id",brandId);
        }

        String min = (String) params.get("min");
        if (!StringUtils.isEmpty(min)) {
            queryWrapper.ge("price",min);
        }

        String max = (String) params.get("max");

        if (!StringUtils.isEmpty(max)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(max);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    queryWrapper.le("price",max);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // key:
        // catelogId: 225
        // brandId: 9
        // min: 0
        // max: 0

        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        List<SkuInfoEntity> list = this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id", spuId));

        return list;
    }

    @Override
    public SkuItemVo item(Long skuId) {
//        SkuItemVo skuItemVo = new SkuItemVo();
//        //1、sku基本信息获取 pms_sku_info
//        CompletableFuture<SkuInfoEntity> infoFuture = CompletableFuture.supplyAsync(() -> {
//            SkuInfoEntity info = getById(skuId);
//            skuItemVo.setInfo(info);
//            return info;
//        }, executor);
//        //3、获取spu的销售属性组合
//        CompletableFuture<Void> saleAttrFuture = infoFuture.thenAcceptAsync((res) -> {
//            List<SkuItemSaleAttrVo> saleAttrVos = skuSaleAttrValueService.getSaleAttrsBySpuId(res.getSpuId());
//            skuItemVo.setSaleAttr(saleAttrVos);
//        }, executor);
//        //4、获取spu的介绍 pms_spu_info_desc
//        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync(res -> {
//            SpuInfoDescEntity spuInfoDescEntity = spuInfoDescService.getById(res.getSpuId());
//            skuItemVo.setDesc(spuInfoDescEntity);
//        }, executor);
//        //5、获取spu的规格参数信息
//        CompletableFuture<Void> attrGroupFuture = infoFuture.thenAcceptAsync(res -> {
//            List<SpuItemAttrGroupVo> attrGroupVos = attrGroupService.getAttrGroupWithAttrsBySpuId(res.getSpuId(), res.getCatalogId());
//            skuItemVo.setGroupAttrs(attrGroupVos);
//        }, executor);
//        //2、sku图片信息    pms_sku_images
//        CompletableFuture<Void> imgFuture = CompletableFuture.runAsync(() -> {
//            List<SkuImagesEntity> skuImagesEntityList = imagesService.getImagesBySkuId(skuId);
//            skuItemVo.setImages(skuImagesEntityList);
//        }, executor);
//
//        CompletableFuture<Void> seckillFuture = CompletableFuture.runAsync(() -> {
//            //3、远程调用查询当前sku是否参与秒杀优惠活动
//            R skuSeckilInfo = seckillFeignService.getSkuSeckilInfo(skuId);
//            if (skuSeckilInfo.getCode() == 0) {
//                //查询成功
//                SeckillSkuVo seckilInfoData = skuSeckilInfo.getData("data", new TypeReference<SeckillSkuVo>() {
//                });
//                skuItemVo.setSeckillSkuVo(seckilInfoData);
//
//                if (seckilInfoData != null) {
//                    long currentTime = System.currentTimeMillis();
//                    if (currentTime > seckilInfoData.getEndTime()) {
//                        skuItemVo.setSeckillSkuVo(null);
//                    }
//                }
//            }
//        }, executor);
//        //等待所有任务都完成
//
//
//
//
//        try {
//            CompletableFuture.allOf(saleAttrFuture,descFuture,attrGroupFuture,imgFuture).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        return skuItemVo;








        SkuItemVo skuItemVo = new SkuItemVo();

        CompletableFuture<SkuInfoEntity> infoFuture = CompletableFuture.supplyAsync(() -> {
            //1sku
            SkuInfoEntity infoEntity = getById(skuId);
            skuItemVo.setSkuInfoEntity(infoEntity);
            return infoEntity;
        }, executor);

        CompletableFuture<Void> saleAttrFuture=infoFuture.thenAcceptAsync((res) -> {
            //3spu
            List<SkuItemSaleAttrVo> saleAttrVos = skuSaleAttrValueService.getSaleAttrsBySpuId(res.getSpuId());
            skuItemVo.setSaleAttr(saleAttrVos);
        }, executor);

        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync((res) -> {
            //4spu介绍
            SpuInfoDescEntity spuInfoDescEntity = spuInfoDescService.getById(res.getSpuId());
            skuItemVo.setDesc(spuInfoDescEntity);
        },executor);

        CompletableFuture<Void> attrGroupFuture = infoFuture.thenAcceptAsync(res -> {
            //5获取规格参数信息
            List<SpuItemAttrGroupVo> attrGroupVos = attrGroupService.getAttrGroupWithAttrsBySpuId(res.getSpuId(), res.getCatalogId());
            skuItemVo.setGroupAttrs(attrGroupVos);
        }, executor);

        CompletableFuture<Void> imagesFuture = CompletableFuture.runAsync(() -> {
            //2sku
            List<SkuImagesEntity> Images = imagesService.getImagesBySkuId(skuId);
            skuItemVo.setImages(Images);
        }, executor);

//        CompletableFuture<Void> seckillFuture = CompletableFuture.runAsync(() -> {
//            //3、远程调用查询当前sku是否参与秒杀优惠活动
//            R skuSeckilInfo = seckillFeignService.getSkuSeckilInfo(skuId);
//            if (skuSeckilInfo.getCode() == 0) {
//                //查询成功
//                SeckillSkuVo seckilInfoData = skuSeckilInfo.getData("data", new TypeReference<SeckillSkuVo>() {
//                });
//                skuItemVo.setSeckillSkuVo(seckilInfoData);
//
//                if (seckilInfoData != null) {
//                    long currentTime = System.currentTimeMillis();
//                    if (currentTime > seckilInfoData.getEndTime()) {
//                        skuItemVo.setSeckillSkuVo(null);
//                    }
//                }
//            }
//        }, executor);
        //等待所有任务都完成

        try {
            CompletableFuture.allOf(saleAttrFuture,descFuture,attrGroupFuture,imagesFuture).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return skuItemVo;
    }

}























