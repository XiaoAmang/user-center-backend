package com.zzx.usercenter.service;

import com.zzx.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务接口
 *
 * @author 19086
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param planetCode    校验码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param request  请求体
     * @return  返回脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     *
     *
     * @param user 脱敏前
     * @return  返回脱敏后的user
     */
    User getSafetyUser(User user);

    /**
     *
     * @param request   请求体
     *
     */
    Integer userLogout(HttpServletRequest request);
}
