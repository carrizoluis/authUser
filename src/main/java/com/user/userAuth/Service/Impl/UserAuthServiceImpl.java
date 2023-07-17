package com.user.userAuth.Service.Impl;

import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Dto.UserResponseDTO;
import com.user.userAuth.Model.Entity.User;
import com.user.userAuth.Model.Exception.BadRequestException;
import com.user.userAuth.Repository.UserRepository;
import com.user.userAuth.Service.UserAuthService;
import com.user.userAuth.Util.Mapper.UserMapper;
import com.user.userAuth.Util.ValidationHelper;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationHelper validationHelper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO request) throws BadRequestException {

        try{
            this.validationHelper.validateBody(request);

            User user = userMapper.mapRequestToEntity(request);

            userRepository.save(user);

        }catch(BadRequestException ex){
            throw ex;
        }

        return new UserResponseDTO();
    }


}
