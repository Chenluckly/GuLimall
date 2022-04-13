/** Copyright 2020 bejson.com */
package com.wh.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Auto-generated: 2020-05-31 11:3:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

@Data
public class MemberPrice {

  private Long id;
  private String name;
  private BigDecimal price;

  public MemberPrice() {
  }

  public MemberPrice(Long id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
