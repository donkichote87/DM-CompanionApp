package pl.basicstuff.dmcompanionapp.data.firstname;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = FirstName.TABLE_NAME)
public class FirstName {
    public static final String TABLE_NAME = "first_names";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String name;
    @Pattern(regexp = "[MF]", message = "{choose.sex}")
    @Column(length = 1)
    private String sex;
    @NotBlank(message = "{choose.race}")
    private String race;


}
