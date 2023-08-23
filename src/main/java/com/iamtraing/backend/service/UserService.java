package com.iamtraing.backend.service;

import com.iamtraing.backend.entity.User;
import com.iamtraing.backend.exception.BaseException;
import com.iamtraing.backend.exception.UserException;
import com.iamtraing.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(String email, String password, String name) throws BaseException {
        //validate
        if (Objects.isNull(email)) {
            throw UserException.createEmailNull();
        }

        if (Objects.isNull(password)) {
            throw UserException.createPasswordNull();
        }

        if (Objects.isNull(name)) {
            throw UserException.createNameNull();
        }

        //verify
        if (repository.existsByEmail(email)) {
            throw UserException.createEmailDuplicate();
        }

        //save
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);
        return repository.save(entity);
    }

}
