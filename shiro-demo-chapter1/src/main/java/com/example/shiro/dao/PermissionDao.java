package com.example.shiro.dao;

import com.example.shiro.model.SysPermission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionDao extends CrudRepository<SysPermission,Long> {
}
