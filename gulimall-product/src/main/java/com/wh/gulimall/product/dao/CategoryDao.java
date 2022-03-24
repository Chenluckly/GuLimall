package com.wh.gulimall.product.dao;

import com.wh.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 18:41:24
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
