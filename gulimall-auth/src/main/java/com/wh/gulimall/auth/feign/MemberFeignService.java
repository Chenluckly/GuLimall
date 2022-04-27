package com.wh.gulimall.auth.feign;



import com.wh.common.utils.R;
import com.wh.gulimall.auth.vo.SocialUser;
import com.wh.gulimall.auth.vo.UserLoginVo;
import com.wh.gulimall.auth.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author yaoxinjia
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {

    @GetMapping("/member/member/register")
    R register(@RequestBody UserRegisterVo userRegisterVo);

    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);


    @PostMapping("/member/member/oauth2/login")
    R oauth2Login(@RequestBody SocialUser vo) throws Exception;
////
//    @PostMapping(value = "/member/member/weixin/login")
//    R weixinLogin(@RequestParam("accessTokenInfo") String accessTokenInfo);
}
