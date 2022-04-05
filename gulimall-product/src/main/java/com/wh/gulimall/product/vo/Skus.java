/** Copyright 2020 bejson.com */
package com.wh.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2020-05-31 11:3:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

@Data
public class Skus {

  private List<com.wh.gulimall.product.vo.Attr> attr;
  private String skuName;
  private BigDecimal price;
  private String skuTitle;
  private String skuSubtitle;
  private List<com.wh.gulimall.product.vo.Images> images;
  private List<String> descar;
  private int fullCount;
  private BigDecimal discount;
  private int countStatus;
  private BigDecimal fullPrice;
  private BigDecimal reducePrice;
  private int priceStatus;
  private List<com.wh.gulimall.product.vo.MemberPrice> memberPrice;

}
