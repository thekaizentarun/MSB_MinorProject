package org.ncu.hirewheels.service;

import org.ncu.hirewheels.entities.ResponseUser;
import org.ncu.hirewheels.entities.UserLogin;
import org.ncu.hirewheels.entities.Users;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserAlreadyExistException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;

public interface UserService {
    public Boolean createUser(Users users)throws UserAlreadyExistException;
    public ResponseUser getUsers(UserLogin userLogin) throws UnauthorizedUserException, UserNotRegisteredException;
}
