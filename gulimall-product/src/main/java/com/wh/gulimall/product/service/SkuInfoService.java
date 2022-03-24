package com.wh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 18:41:24
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
