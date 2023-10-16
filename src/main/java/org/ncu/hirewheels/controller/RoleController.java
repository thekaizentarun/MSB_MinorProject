package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping(value = "/role")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.addRole(role), HttpStatus.CREATED);
    }
    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>>  getAllRoles(){
        return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.ACCEPTED);
    }
}
