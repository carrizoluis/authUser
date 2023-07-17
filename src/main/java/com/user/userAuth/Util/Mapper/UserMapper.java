package com.user.userAuth.Util.Mapper;

import com.user.userAuth.Model.Dto.PhoneDTO;
import com.user.userAuth.Model.Dto.SignUpRequestDTO;
import com.user.userAuth.Model.Entity.Phone;
import com.user.userAuth.Model.Entity.User;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User mapRequestToEntity(SignUpRequestDTO userRequestDTO){
        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setCreatedAt(Date.valueOf(LocalDate.now()));
        if(!userRequestDTO.getPhoneDTOS().isEmpty()){
            List<Phone> phoneEntityList = new ArrayList<Phone>();
            for(PhoneDTO p: userRequestDTO.getPhoneDTOS()){
                Phone phoneEntity = new Phone();
                phoneEntity.setCityCode(p.getCityCode());
                phoneEntity.setNumber(p.getNumber());
                phoneEntity.setCountryCode(p.getCountryCode());
                phoneEntityList.add(phoneEntity);
            }
            user.setPhones(phoneEntityList);
        }

        return user;
    }

}

