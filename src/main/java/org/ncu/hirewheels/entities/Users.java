package org.ncu.hirewheels.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users_hirewheels")
public class Users {

    // user_id NUMERIC(10)  PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private int userId;
    // first_name VARCHAR(50)  NOT NULL
    @Column(nullable = false,length = 50)
    private String firstName;
    // last_name VARCHAR(50)
    @Column(length = 50)
    private String lastName;
    // password VARCHAR(50) NOT NULL CHECK = length> 5 characters
    @Size(min = 6)
    @Column(length = 50,nullable = false)
    private String password;
    // email VARCHAR(50) NOT NULL UNIQUE
    @Column(length = 50,nullable = false,unique = true)
    private String email;
    // mobile_no CHAR(10) NOT NULL UNIQUE
    @Column(length = 10,nullable = false,unique = true)
    private String mobileNo;
    // wallet_money NUMERIC(10,2) DEFAULT = 10000.00
    @Column(length = 8)
    private float walletMoney = 10000.00f;


    // role_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Booking> bookings;


    public Users() {
    }

    public Users(int userId, String firstName, String lastName, String password, String email, String mobileNo, float walletMoney, Role role, Set<Booking> bookings) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNo = mobileNo;
        this.walletMoney = walletMoney;
        this.role = role;
        this.bookings = bookings;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public float getWalletMoney() {
        return this.walletMoney;
    }

    public void setWalletMoney(float walletMoney) {
        this.walletMoney = walletMoney;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobileNo='" + getMobileNo() + "'" +
            ", walletMoney='" + getWalletMoney() + "'" +
            ", role='" + getRole() + "'" +
            ", bookings='" + getBookings() + "'" +
            "}";
    }

}
