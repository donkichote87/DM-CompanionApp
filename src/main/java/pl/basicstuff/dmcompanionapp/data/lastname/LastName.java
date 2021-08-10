package pl.basicstuff.dmcompanionapp.data.lastname;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = LastName.TABLE_NAME)
public class LastName {
    public static final String TABLE_NAME = "last_names";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String name;
    @NotBlank(message = "{choose.race}")
    private String race;


}
