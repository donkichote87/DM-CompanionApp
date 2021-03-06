package pl.basicstuff.dmcompanionapp.data.background;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Background.TABLE_NAME)
public class Background {
    public static final String TABLE_NAME = "backgrounds";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String name;
}
