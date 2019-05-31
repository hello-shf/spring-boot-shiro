package com.example.shiro.dao;

import com.example.shiro.model.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<SysUser,Long> {
    /**通过username查找用户信息;*/
    public SysUser findByUsername(String username);
}