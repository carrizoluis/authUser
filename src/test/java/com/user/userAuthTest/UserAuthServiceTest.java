package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.model.exception.BadRequestException;
import com.user.userAuth.repository.UserRepository;
import com.user.userAuth.service.impl.UserAuthServiceImpl;
import com.user.userAuth.util.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootConfig.class)
public class UserAuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserAuthServiceImpl userAuthService;

    @Test
    public void signUpAndIsOk() throws BadRequestException {
        SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO("lucho","test@hotmail.com","passtest",null);

        User userToSave = new User(0,"lucho","test@hotmail.com","passtest", null, true, null);

        User userResponse = new User(1,"lucho","test@hotmail.com","passtest", null, true, null);

        UserResponseDTO responseExpected = new UserResponseDTO(1,"2023","2023","aaaddd222",true);

        Mockito.when(userRepository.findByEmail(signUpRequestDTO.getEmail())).thenReturn(null);

        Mockito.when(userMapper.mapRequestToEntity(signUpRequestDTO)).thenReturn(userToSave);

        Mockito.when(userRepository.save(userToSave)).thenReturn(userResponse);

        Mockito.when(userMapper.mapEntityToResponse(userResponse)).thenReturn(responseExpected);

        UserResponseDTO actualResponse = userAuthService.signUp(signUpRequestDTO);


        assertThat(actualResponse).isEqualTo(responseExpected);

    }

    @Test
    public void signUpAndEmailIsWrong() throws BadRequestException {
        try{
            SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO("lucho","test","passtest",null);

            User userToSave = new User(0,"lucho","test","passtest", null, true, null);

            User userResponse = new User(1,"lucho","test@hotmail.com","passtest", null, true, null);

            UserResponseDTO responseExpected = new UserResponseDTO(1,"2023","2023","aaaddd222",true);

            Mockito.when(userRepository.findByEmail(signUpRequestDTO.getEmail())).thenReturn(null);

            UserResponseDTO actualResponse = userAuthService.signUp(signUpRequestDTO);
        }catch(BadRequestException ex){
            assertThat(ex).isInstanceOf(BadRequestException.class);
            assertThat(ex.getMessage()).isEqualTo("Email has not valid format");
        }
    }

    @Test
    public void signUpAndUserAlreadyExists(){
        try{
            SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO("lucho","test","passtest",null);

            User userToSave = new User(0,"lucho","test","passtest", null, true, null);

            User userResponse = new User(1,"lucho","test@hotmail.com","passtest", null, true, null);

            UserResponseDTO responseExpected = new UserResponseDTO(1,"2023","2023","aaaddd222",true);

            Mockito.when(userRepository.findByEmail(signUpRequestDTO.getEmail())).thenReturn(userResponse);

            UserResponseDTO actualResponse = userAuthService.signUp(signUpRequestDTO);
        }catch(BadRequestException ex){
            assertThat(ex).isInstanceOf(BadRequestException.class);
            assertThat(ex.getMessage()).isEqualTo("User Already Exists");
        }
    }

    @Test
    public void testPasswordIsntExists(){
        try{
            SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO("lucho","test","",null);

            User userToSave = new User(0,"lucho","test","passtest", null, true, null);

            User userResponse = new User(1,"lucho","test@hotmail.com","passtest", null, true, null);

            UserResponseDTO responseExpected = new UserResponseDTO(1,"2023","2023","aaaddd222",true);

            Mockito.when(userRepository.findByEmail(signUpRequestDTO.getEmail())).thenReturn(userResponse);

            UserResponseDTO actualResponse = userAuthService.signUp(signUpRequestDTO);
        }catch(BadRequestException ex){
            assertThat(ex).isInstanceOf(BadRequestException.class);
            assertThat(ex.getMessage()).isEqualTo("Password is null or empty");
        }
    }

}
