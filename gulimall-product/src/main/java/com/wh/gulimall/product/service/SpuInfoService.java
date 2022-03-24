package com.wh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 18:41:24
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

