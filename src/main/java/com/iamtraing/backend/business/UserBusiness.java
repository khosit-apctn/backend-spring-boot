package com.iamtraing.backend.business;

import com.iamtraing.backend.entity.User;
import com.iamtraing.backend.exception.BaseException;
import com.iamtraing.backend.exception.FileException;
import com.iamtraing.backend.model.MRegisterRequest;
import com.iamtraing.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserBusiness {

    private final UserService userService;

    public UserBusiness(UserService userservice) {
        this.userService = userservice;
    }

    public User register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());

        //TODO:mapper

        return user;
    }

    public String uploadProfilePicture(MultipartFile file) throws BaseException {
        //validate file
        if ( file == null ) {
            //throw error
            throw FileException.fileNull();
        }
        //validate size
        if ( file.getSize() > 1048576 * 2 ) {
            //throw error
            throw FileException.fileMaxSize();
        }

        String contentType = file.getContentType();

        if ( contentType == null ){
            //throw error
            throw FileException.unsupported();
        }

        List<String> supportedTypes = Arrays.asList("img/jpeg", "image/png");
        if (!supportedTypes.contains(contentType)){
            //throw error(unsupported)
            throw FileException.unsupported();
        }


        // TODO : upload file File Storage (AWS , S3 , etc.....)
        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
