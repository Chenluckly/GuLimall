package com.wh.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.to.OrderTo;
import com.wh.common.to.SkuHasStockVo;
import com.wh.common.to.mq.StockLockedTo;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.ware.entity.WareSkuEntity;
import com.wh.gulimall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 20:00:58
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 添加库存
     * @param skuId
     * @param wareId
     * @param skuNum
     */
    void addStock(Long skuId, Long wareId, Integer skuNum);


    /**
     * 判断是否有库存
     * @param skuIds
     * @return
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

//    /**
//     * 锁定库存
//     * @param vo
//     * @return
//     */
//    boolean orderLockStock(WareSkuLockVo vo);
//
//
//    /**
//     * 解锁库存
//     * @param to
//     */
//    void unlockStock(StockLockedTo to);
//
//    /**
//     * 解锁订单
//     * @param orderTo
//     */
//    void unlockStock(OrderTo orderTo);
}

