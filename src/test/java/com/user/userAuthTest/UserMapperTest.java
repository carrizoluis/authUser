package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.util.JWTUtil;
import com.user.userAuth.util.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootConfig.class)
public class UserMapperTest {

    @Mock
    private BCryptPasswordEncoder encryptor;

    @Mock
    private JWTUtil jwtUtil;

    @InjectMocks
    private UserMapper userMapper;


    @Test
    public void testMapRequestToEntityAndIsOk() {
        SignUpRequestDTO requestDTO = new SignUpRequestDTO("name", "email@am.com", "password", null);

        User userExpected = new User();
        userExpected.setName("name");
        userExpected.setEmail("email@am.com");
        userExpected.setPassword("paaad");
        userExpected.setCreatedAt(Date.valueOf(LocalDate.now()));

        Mockito.when(encryptor.encode(requestDTO.getPassword())).thenReturn("paaad");

        User actualResult = userMapper.mapRequestToEntity(requestDTO);

        assertThat(actualResult).isEqualTo(userExpected);
    }

    @Test
    public void testMapEntityToResponseAndIsOk() {
        UserResponseDTO userResponseDTOExpected = new UserResponseDTO();
        userResponseDTOExpected.setId(1);
        userResponseDTOExpected.setToken("tokenTest");
        userResponseDTOExpected.setActive(true);
        userResponseDTOExpected.setCreated(Date.valueOf(LocalDate.now()).toString());

        User userActual = new User(1, "lucho", "email@email.com", "password", Date.valueOf(LocalDate.now()), true, null);

        Mockito.when(jwtUtil.getJWTToken(userActual)).thenReturn("tokenTest");

        UserResponseDTO actualResult = userMapper.mapEntityToResponse(userActual);

        assertThat(actualResult).isEqualTo(userResponseDTOExpected);
    }

}
