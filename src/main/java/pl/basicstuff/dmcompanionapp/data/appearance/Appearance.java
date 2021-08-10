package pl.basicstuff.dmcompanionapp.data.appearance;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Appearance.TABLE_NAME)
public class Appearance {
    public static final String TABLE_NAME = "appearances";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String description;
}
