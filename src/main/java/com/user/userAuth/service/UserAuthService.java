package com.user.userAuth.service;

import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.exception.BadRequestException;

public interface UserAuthService {


    /** This Method enrolls a new user, it returns a new user with a
     * token to do a login.
     *
     * @return JSON Response DTO
     */
    public UserResponseDTO signUp(SignUpRequestDTO request) throws BadRequestException;

}
