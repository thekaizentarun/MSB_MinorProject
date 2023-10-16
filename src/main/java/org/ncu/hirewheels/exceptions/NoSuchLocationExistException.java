


package org.ncu.hirewheels.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchLocationExistException extends RuntimeException{
    private String message;


    public NoSuchLocationExistException() {
        message = "No Such Location Exist";
    }

    public NoSuchLocationExistException(String message) {
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

