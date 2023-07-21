package com.user.userAuth.util.mapper;

import com.user.userAuth.model.dto.PhoneDTO;
import com.user.userAuth.model.dto.SignUpRequestDTO;
import com.user.userAuth.model.dto.UserResponseDTO;
import com.user.userAuth.model.entity.Phone;
import com.user.userAuth.model.entity.User;
import com.user.userAuth.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder encryptor;

    @Autowired
    private JWTUtil jwtUtil;

    public User mapRequestToEntity(SignUpRequestDTO userRequestDTO) {
        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(encryptor.encode(userRequestDTO.getPassword()));
        user.setCreatedAt(Date.valueOf(LocalDate.now()));
        if (userRequestDTO.getPhoneDTOS() != null) {
            List<Phone> phoneEntityList = new ArrayList<Phone>();
            for (PhoneDTO p : userRequestDTO.getPhoneDTOS()) {
                Phone phoneEntity = new Phone();
                phoneEntity.setCityCode(p.getCityCode());
                phoneEntity.setNumber(p.getNumber());
                phoneEntity.setCountryCode(p.getCountryCode());
                phoneEntity.setUser(user);
                phoneEntityList.add(phoneEntity);
            }
            user.setPhones(phoneEntityList);
        }

        return user;
    }

    public UserResponseDTO mapEntityToResponse(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getUserid());
        response.setToken(jwtUtil.getJWTToken(user));
        response.setCreated(user.getCreatedAt().toString());
        response.setActive(user.isActive());
        return response;
    }

}

