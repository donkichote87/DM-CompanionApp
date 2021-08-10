package pl.basicstuff.dmcompanionapp.data.occupation;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Occupation.TABLE_NAME)
public class Occupation {
    public static final String TABLE_NAME = "occupations";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 100, unique = true)
    private String nameMale;
    @NotBlank
    @Column(length = 100, unique = true)
    private String nameFemale;

}
