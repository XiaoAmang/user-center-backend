package com.zzx.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author zzx
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 222874985276018008L;

    private String userAccount;

    private String userPassword;
}
