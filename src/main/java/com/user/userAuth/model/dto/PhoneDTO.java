package com.user.userAuth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long number;
    private Integer cityCode;
    private String countryCode;
}
