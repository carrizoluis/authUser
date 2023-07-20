package com.user.userAuth.Service.Impl;

import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Dto.UserResponseDTO;
import com.user.userAuth.Model.Entity.Phone;
import com.user.userAuth.Model.Entity.User;
import com.user.userAuth.Model.Exception.BadRequestException;
import com.user.userAuth.Repository.PhoneRepository;
import com.user.userAuth.Repository.UserRepository;
import com.user.userAuth.Service.UserAuthService;
import com.user.userAuth.Util.Mapper.UserMapper;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
