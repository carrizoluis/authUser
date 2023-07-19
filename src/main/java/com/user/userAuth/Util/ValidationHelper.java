package com.user.userAuth.Util;

import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Exception.BadRequestException;
import com.user.userAuth.Repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {

    @Autowired
    private UserRepository userRepository;

    public void validateBody(SignUpRequestDTO body) throws BadRequestException {


    }

}
