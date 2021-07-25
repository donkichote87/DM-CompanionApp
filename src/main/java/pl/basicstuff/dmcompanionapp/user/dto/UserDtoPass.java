package pl.basicstuff.dmcompanionapp.user.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDtoPass {

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "{password.notValid}")
    @NotNull
    @NotBlank
    private String password;

}
