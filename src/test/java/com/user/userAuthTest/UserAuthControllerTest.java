package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.controller.UserAuthController;
import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.exception.BadRequestException;
import com.user.userAuth.service.UserAuthService;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = SpringBootConfig.class)
public class UserAuthControllerTest {

    @Mock
    private UserAuthService userAuthService;

    @InjectMocks
    private UserAuthController userAuthController;

    @Test
    public void SignUpAndIsOK() throws BadRequestException {

        SignUpRequestDTO request = new SignUpRequestDTO("name","email@hotmail.com","testpass",null);

        UserResponseDTO responseDTO = new UserResponseDTO(1,"2023","2023-03-21","tokenTest",true);

        Mockito.when(userAuthService.signUp(request)).thenReturn(responseDTO);

        UserResponseDTO responseMethod = userAuthController.signUp(request);;

        assertThat(responseMethod)
                .isEqualTo(responseDTO);

    }

}
