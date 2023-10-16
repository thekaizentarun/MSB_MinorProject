package org.ncu.hirewheels.entities;

public class BookingUser {
    private Booking booking;
    private UserLogin userLogin;

    public BookingUser(Booking booking, UserLogin userLogin) {
        this.booking = booking;
        this.userLogin = userLogin;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public UserLogin getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "{" +
            " booking='" + getBooking() + "'" +
            ", userLogin='" + getUserLogin() + "'" +
            "}";
    }

}
