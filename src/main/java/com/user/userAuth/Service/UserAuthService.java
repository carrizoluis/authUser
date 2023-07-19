package com.user.userAuth.Service;

import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Dto.UserResponseDTO;
import com.user.userAuth.Model.Exception.BadRequestException;

public interface UserAuthService {


    /** This Method enrolls a new user, it returns a new user with a
     * token to do a login.
     *
     * @return JSON Response DTO
     */
    public UserResponseDTO signUp(SignUpRequestDTO request) throws BadRequestException;

}
