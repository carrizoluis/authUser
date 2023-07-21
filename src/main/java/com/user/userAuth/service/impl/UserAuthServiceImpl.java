package com.user.userAuth.service.impl;

import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.model.exception.BadRequestException;
import com.user.userAuth.repository.UserRepository;
import com.user.userAuth.service.UserAuthService;
import com.user.userAuth.util.mapper.UserMapper;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO request) throws BadRequestException {

        try{
            if(request.getPassword().isEmpty() || request.getPassword().equals(null)){
                throw new BadRequestException("Password is null or empty", HttpStatus.BAD_REQUEST);
            }

            //validar formato

            if(userRepository.findByEmail(request.getEmail()) != null){
                throw new BadRequestException("User Already Exists", HttpStatus.BAD_REQUEST);
            }

            if(!EmailValidator.getInstance().isValid(request.getEmail())){
                throw new BadRequestException("Email has not valid format", HttpStatus.BAD_REQUEST);
            }

            User savedUser = userRepository.save(userMapper.mapRequestToEntity(request));

            return userMapper.mapEntityToResponse(savedUser);

        }catch(BadRequestException ex){
            throw ex;
        }
    }


}
