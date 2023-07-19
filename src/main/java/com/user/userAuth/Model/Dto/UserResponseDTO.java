package com.user.userAuth.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private int id;
    private String created;
    private String lastLogin;
    private String token;
    private boolean isActive;

}
