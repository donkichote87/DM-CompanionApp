package pl.basicstuff.dmcompanionapp.data.race;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Race.TABLE_NAME)
public class Race {
    public static final String TABLE_NAME = "races";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60)
    private String generalRace;
    @NotBlank
    @Column(length = 60, unique = true)
    private String subRace;

}
