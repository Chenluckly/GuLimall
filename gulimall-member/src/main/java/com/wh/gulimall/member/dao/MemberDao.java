package com.wh.gulimall.member.dao;

import com.wh.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 19:38:08
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
