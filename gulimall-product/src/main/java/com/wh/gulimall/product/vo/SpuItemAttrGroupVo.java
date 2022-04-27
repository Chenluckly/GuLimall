package com.wh.gulimall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-19 18:18
 **/

@Data
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<SpuBaseAttrVo> attrs;

    @Override
    public String toString() {
        return "SpuItemAttrGroupVo{" +
                "groupName='" + groupName + '\'' +
                ", attrs=" + attrs +
                '}';
    }
}
