package com.wh.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.to.SkuReductionTo;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 19:24:52
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}

