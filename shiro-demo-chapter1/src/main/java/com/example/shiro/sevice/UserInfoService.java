package com.example.shiro.sevice;


import com.example.shiro.model.SysUser;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public SysUser findByUsername(String username);
}