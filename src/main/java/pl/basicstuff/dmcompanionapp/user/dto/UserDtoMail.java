package pl.basicstuff.dmcompanionapp.user.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDtoMail {

    @NotNull
    @NotEmpty
    @Email
    private String email;
}
