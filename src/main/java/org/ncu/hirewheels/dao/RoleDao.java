package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
    
}
