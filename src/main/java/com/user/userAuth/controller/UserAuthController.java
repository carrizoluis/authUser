package com.user.userAuth.controller;

import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.exception.BadRequestException;
import com.user.userAuth.service.UserAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/v1/auth")
@Api(value = "User Authentication", protocols = "http")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/sign-up")
    @Operation(summary = "This Method enrolls a new user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User has signed up", response = UserResponseDTO.class),
            @ApiResponse(code = 400, message = "User has not a required field", response = HttpClientErrorException.BadRequest.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpServerErrorException.InternalServerError.class)
    })
    public UserResponseDTO signUp(@Validated(SignUpRequestDTO.class) @RequestBody SignUpRequestDTO request) throws BadRequestException {
        return userAuthService.signUp(request);
    }

}
