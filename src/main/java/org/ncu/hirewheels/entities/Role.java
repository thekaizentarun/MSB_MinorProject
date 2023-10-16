package org.ncu.hirewheels.entities;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role_hirewheels")
public class Role {
    // role_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    // role_name VARCHAR(50) NOT NULL UNIQUE
    @Column(nullable = false,unique = true, length = 50)
    private String roleName;
    
    // @OneToMany(mappedBy = "role")
    // Set<Users> users;

    public Role() {
    }

    public Role(int roleId, String roleName
    // , Set<Users> users
    ) {
        this.roleId = roleId;
        this.roleName = roleName;
        // this.users = users;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // public Set<Users> getUsers() {
    //     return this.users;
    // }

    // public void setUsers(Set<Users> users) {
    //     this.users = users;
    // }

    @Override
    public String toString() {
        return "{" +
            " roleId='" + getRoleId() + "'" +
            ", roleName='" + getRoleName() + "'" +
            // ", users='" + getUsers() + "'" +
            "}";
    }

}
