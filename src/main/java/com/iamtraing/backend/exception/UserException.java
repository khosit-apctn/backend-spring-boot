package com.iamtraing.backend.exception;

public class UserException extends BaseException{

    public UserException(String code) {
        super("user."+code );
    }
    //user .register.email.null
    public static UserException requestNull(){
        return new UserException("register.request.null");
    }
    //user .register.email.null
    public static UserException emailNull(){
        return new UserException("register.email.null");
    }

    // CREATE

    public static UserException createEmailNull(){
        return new UserException("create.email.null");
    }

    public static UserException createEmailDuplicate(){
        return new UserException("create.email.Duplicate");
    }

    public static UserException createPasswordNull(){
        return new UserException("create.password.null");
    }

    public static UserException createNameNull(){
        return new UserException("create.name.null");
    }


}
