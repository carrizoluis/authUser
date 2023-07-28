package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootConfig.class)
public class JwtUtilTest {

    private final JWTUtil jwtUtil = new JWTUtil();

    @Test
    public void testGetJWTTokenAndIsOk() {
        User userTest = new User(1, "lucho", "email@email.com", "password", Date.valueOf(LocalDate.now()), true, null);
        String token = jwtUtil.getJWTToken(userTest);
        assertThat(token).isInstanceOf(String.class);
    }

    @Test
    public void validateTokenAndIsOk() {
        User userTest = new User(1, "lucho", "email@email.com", "password", Date.valueOf(LocalDate.now()), true, null);
        boolean isValidtoken = !jwtUtil.validateToken(jwtUtil.getJWTToken(userTest)).isEmpty();
        assertThat(isValidtoken).isEqualTo(true);
    }

}
