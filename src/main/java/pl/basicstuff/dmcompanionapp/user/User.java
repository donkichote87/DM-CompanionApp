package pl.basicstuff.dmcompanionapp.user;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import pl.basicstuff.dmcompanionapp.role.Role;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @NotNull
    @NotBlank
    @Size(min = 4)
    private String username;
    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "{password.notValid}")
    @NotNull
    @NotBlank
    private String password;
    private boolean enabled;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

}