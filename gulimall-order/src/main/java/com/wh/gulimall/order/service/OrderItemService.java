package com.wh.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 19:50:52
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

