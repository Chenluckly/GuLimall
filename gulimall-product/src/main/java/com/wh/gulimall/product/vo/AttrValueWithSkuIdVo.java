package com.wh.gulimall.product.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-23 18:59
 **/

@Data
@ToString
public class AttrValueWithSkuIdVo {

    private String attrValue;

    private String skuIds;

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(String skuIds) {
        this.skuIds = skuIds;
    }
}
