package com.wh.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.common.utils.PageUtils;
import com.wh.gulimall.member.controller.exception.PhoneException;
import com.wh.gulimall.member.controller.exception.UsernameException;
import com.wh.gulimall.member.entity.MemberEntity;
import com.wh.gulimall.member.vo.MemberUserLoginVo;
import com.wh.gulimall.member.vo.MemberUserRegisterVo;
import com.wh.gulimall.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author wh
 * @email 2583661719@qq.com
 * @date 2022-03-24 19:38:08
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 用户注册
     * @param vo
     */
    void register(MemberUserRegisterVo vo);

    /**
     * 判断邮箱是否重复
     * @param phone
     * @return
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     * @param userName
     * @return
     */
    void checkUserNameUnique(String userName) throws UsernameException;

    /**
     * 用户登录
     * @param vo
     * @return
     */
    MemberEntity login(MemberUserLoginVo vo);

    /**
     * 社交用户的登录
     * @param socialUser
     * @return
     */
    MemberEntity auth2login(SocialUser socialUser) throws Exception;

}

