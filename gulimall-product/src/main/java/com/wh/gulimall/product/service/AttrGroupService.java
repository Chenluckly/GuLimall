package com.wh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 18:41:24
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

