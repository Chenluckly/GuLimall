package com.wh.gulimall.member.feign;

import com.wh.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanghu
 * @date 2022/3/24 21:58
 *
 *
 * 这是一个声明式的远程调用
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("coupon/coupon/member/list")
    public R membercoupons();

}
