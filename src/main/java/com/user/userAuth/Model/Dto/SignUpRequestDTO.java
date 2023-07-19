package com.user.userAuth.Model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDTO {

    @Nullable
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

    @Nullable
    @JsonProperty("phones")
    private List<PhoneDTO> phoneDTOS;

}
