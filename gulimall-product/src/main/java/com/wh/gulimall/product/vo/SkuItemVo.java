package com.wh.gulimall.product.vo;

import com.wh.gulimall.product.entity.SkuImagesEntity;
import com.wh.gulimall.product.entity.SkuInfoEntity;
import com.wh.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-19 16:46
 **/

@Data
public class SkuItemVo {

    //1、sku基本信息的获取  pms_sku_info
    private SkuInfoEntity skuInfoEntity;

    private boolean hasStock = true;

    //2、sku的图片信息    pms_sku_images
    private List<SkuImagesEntity> images;

    //3、获取spu的销售属性组合
    private List<SkuItemSaleAttrVo> saleAttr;

    //4、获取spu的介绍
    private SpuInfoDescEntity desc;

    //5、获取spu的规格参数信息
    private List<SpuItemAttrGroupVo> groupAttrs;


//    //6、秒杀商品的优惠信息
//    private com.wh.gulimall.product.vo.SeckillSkuVo seckillSkuVo;

}
