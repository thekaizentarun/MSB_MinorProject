



package org.ncu.hirewheels.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchVehicleCategoryExistException extends RuntimeException{
    private String message;


    public NoSuchVehicleCategoryExistException() {
        message = "Vehicle Subcategory Doesn't Exist";
    }

    public NoSuchVehicleCategoryExistException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }
    

}
