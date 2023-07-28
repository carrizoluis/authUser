package com.user.userAuth.service.impl;

import com.user.userAuth.model.dto.PhoneDTO;
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
import org.springframework.util.StringUtils;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO request) throws BadRequestException {

        try {

            if (!StringUtils.hasText(request.getPassword())) {
                throw new BadRequestException("Password is null or empty", HttpStatus.BAD_REQUEST);
            }

            if(!StringUtils.hasText(request.getEmail())){
                throw new BadRequestException("Email is null or empty", HttpStatus.BAD_REQUEST);
            }

            if (!EmailValidator.getInstance().isValid(request.getEmail())) {
                throw new BadRequestException("Email has not valid format", HttpStatus.BAD_REQUEST);
            }

            //validar formato

            if (userRepository.findByEmail(request.getEmail()) != null) {
                throw new BadRequestException("User Already Exists", HttpStatus.BAD_REQUEST);
            }

            //VALIDAMOS DATOS DE TELEFONO
            if(request.getPhoneDTOS() != null){

                for(PhoneDTO phone: request.getPhoneDTOS()){
                    if(phone.getNumber() == null || phone.getNumber() == 0){
                        throw new BadRequestException("Phone number is required", HttpStatus.BAD_REQUEST);
                    }

                    if(phone.getCityCode() == null || phone.getCityCode() == 0){
                        throw new BadRequestException("City Code is required", HttpStatus.BAD_REQUEST);
                    }

                    if(!StringUtils.hasText(phone.getCountryCode()) || phone.getCountryCode().equals("0")){
                        throw new BadRequestException("Country Code is required", HttpStatus.BAD_REQUEST);
                    }
                }
            }

            User savedUser = userRepository.save(userMapper.mapRequestToEntity(request));

            return userMapper.mapEntityToResponse(savedUser);

        } catch (BadRequestException ex) {
            throw ex;
        }
    }


}
