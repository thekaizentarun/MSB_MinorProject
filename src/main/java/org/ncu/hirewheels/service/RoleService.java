package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.Role;

public interface RoleService {
    public Role addRole(Role role);
    public List<Role> getAllRoles();
}
