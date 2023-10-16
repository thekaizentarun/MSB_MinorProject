package org.ncu.hirewheels.service.impl;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.ncu.hirewheels.dao.RoleDao;
import org.ncu.hirewheels.dao.UsersDao;
import org.ncu.hirewheels.entities.ResponseUser;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.UserLogin;
import org.ncu.hirewheels.entities.Users;
import org.ncu.hirewheels.exceptions.NoSuchRoleExistException;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserAlreadyExistException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UsersDao userDao;
    private RoleDao roleDao;

    public UserServiceImpl(UsersDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public Boolean createUser(Users users) throws UserAlreadyExistException {

        Users user = userDao.findEmailIdUsers(users.getEmail());
        if(user != null){
            throw new UserAlreadyExistException();
        }
        Optional<Role> role = roleDao.findById(users.getRole().getRoleId());

        if(!role.isPresent()){
            throw new NoSuchRoleExistException();
        }
        // TODO Auto-generated method stub
        user = userDao.save(users);
        if(user != null){
            int id = user.getUserId();
            return userDao.existsById(id);
        }
        return false;
    }

    @Override
    public ResponseUser getUsers(UserLogin userLogin) throws UnauthorizedUserException, UserNotRegisteredException {
        // TODO Auto-generated method stub
        String email = userLogin.getEmail();
        String password = userLogin.getPassword();
        Users user = userDao.findEmailIdUsers(email);
        // System.out.println(user);
        if(user == null){
            System.out.println("Entering Block 1");
            throw new UserNotRegisteredException();
        }

        user = userDao.findEmailAndPasswordUsers(email, password);
        // System.out.println("The User is "+user);
        if(user == null){
            System.out.println("Entering Block 2");
            throw new UnauthorizedUserException("Unauthorized User");
        }
        // System.out.println(user);

        ResponseUser responseUser = new ResponseUser();
        responseUser.setEmail(user.getEmail());
        responseUser.setFirstName(user.getFirstName());
        responseUser.setLastName(user.getLastName());
        responseUser.setMobileNo(user.getMobileNo());
        responseUser.setRoleId(user.getRole().getRoleId());
        responseUser.setUserId(user.getUserId());
        responseUser.setWalletMoney(user.getWalletMoney());
        return responseUser;
    }
    
}
