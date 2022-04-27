package com.wh.gulimall.product.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-19 18:19
 **/

@Data
public class SpuBaseAttrVo {

    private String attrName;

    private String attrValue;

    @Override
    public String toString() {
        return "SpuBaseAttrVo{" +
                "attrName='" + attrName + '\'' +
                ", attrValue='" + attrValue + '\'' +
                '}';
    }

}
