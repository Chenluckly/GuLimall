package com.wh.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.member.entity.MemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 19:38:08
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

