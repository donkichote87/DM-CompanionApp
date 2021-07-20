package pl.basicstuff.dmcompanionapp.user;

import lombok.Data;
import pl.basicstuff.dmcompanionapp.role.Role;

import javax.persistence.*;

@Entity
@Data
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private int enabled;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

}