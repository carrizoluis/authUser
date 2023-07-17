package com.user.userAuth.Util;

import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Exception.BadRequestException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {

    public void validateBody(SignUpRequestDTO body) throws BadRequestException {
        if(body.getPassword().isEmpty() || body.getPassword().equals(null)){
            throw new BadRequestException("Password is null or empty", HttpStatus.BAD_REQUEST);
        }

        //validar formato

        if(!EmailValidator.getInstance().isValid(body.getEmail())){
            throw new BadRequestException("Email has not valid format", HttpStatus.BAD_REQUEST);
        }

    }

}
