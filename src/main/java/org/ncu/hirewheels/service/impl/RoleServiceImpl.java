package org.ncu.hirewheels.service.impl;

import java.util.List;

import org.ncu.hirewheels.dao.RoleDao;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role addRole(Role role) {
        // TODO Auto-generated method stub
        return roleDao.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        // TODO Auto-generated method stub
        return roleDao.findAll();
    }
    
}
