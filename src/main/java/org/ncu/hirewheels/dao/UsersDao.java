package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersDao extends JpaRepository<Users, Integer>{
    @Query(value = "SELECT u FROM Users u WHERE u.email = :email")
    public Users findEmailIdUsers(@Param("email") String email);

    @Query(value = "SELECT u FROM Users u WHERE (u.email = :email AND u.password = :password)")
    public Users findEmailAndPasswordUsers(@Param("email") String email, @Param("password") String password);
}
