package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.model.dto.PhoneDTO;
import com.user.userAuth.model.entity.Phone;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.model.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootConfig.class)
public class ModelTest {


    @Test
    public void testPhoneEntity(){
        User user = new User();
        Phone phone = new Phone(user, 1, 22323L, 2323, "233");
        phone.getUser();
        phone.getPhoneid();
        phone.getCityCode();
        phone.getUser();
        phone.getNumber();
        phone.setNumber(233L);
        phone.setCityCode(133);
        phone.setCountryCode("23234");
        phone.setUser(user);
        assertThat(phone).isInstanceOf(Phone.class);
    }

    @Test
    public void testPhoneEmptyCreation(){
        Phone phone = new Phone();
        assertThat(phone).isInstanceOf(Phone.class);
    }

    @Test
    public void testPhoneDTO(){
        PhoneDTO phoneDTO = new PhoneDTO(22323L, 2323, "233");
        assertThat(phoneDTO).isInstanceOf(PhoneDTO.class);
    }

    @Test
    public void testBadRequestExceptionCreationAndGetSetMethods(){
        BadRequestException badRequestException = new BadRequestException("message", HttpStatus.BAD_REQUEST);
        badRequestException.setMessage("other");
        badRequestException.setStatusCode(HttpStatus.ACCEPTED);
        badRequestException.getMessage();
        badRequestException.getStatusCode();
        assertThat(badRequestException).isInstanceOf(BadRequestException.class);
    }
}
