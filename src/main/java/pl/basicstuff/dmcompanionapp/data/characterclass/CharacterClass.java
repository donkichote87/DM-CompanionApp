package pl.basicstuff.dmcompanionapp.data.characterclass;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = CharacterClass.TABLE_NAME)
public class CharacterClass {
    public static final String TABLE_NAME = "classes";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String name;
}
