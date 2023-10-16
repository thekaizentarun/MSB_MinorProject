package org.ncu.hirewheels.entities;

public class UserVehicle {
    private UserLogin userLogin;
    private RequestVehicle requestVehicle;

    public UserVehicle() {
    }
    public UserVehicle(UserLogin userLogin, RequestVehicle requestVehicle) {
        this.userLogin = userLogin;
        this.requestVehicle = requestVehicle;
    }

    public UserLogin getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public RequestVehicle getRequestVehicle() {
        return this.requestVehicle;
    }

    public void setRequestVehicle(RequestVehicle requestVehicle) {
        this.requestVehicle = requestVehicle;
    }

    @Override
    public String toString() {
        return "{" +
            " userLogin='" + getUserLogin() + "'" +
            ", requestVehicle='" + getRequestVehicle() + "'" +
            "}";
    }

   
}
