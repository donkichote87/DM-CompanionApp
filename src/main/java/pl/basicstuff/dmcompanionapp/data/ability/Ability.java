package pl.basicstuff.dmcompanionapp.data.ability;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Ability.TABLE_NAME)
public class Ability {
    public static final String TABLE_NAME = "abilities";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String descriptionMale;
    @NotBlank
    @Column(length = 60, unique = true)
    private String descriptionFemale;
    @NotBlank
    @Column(length = 60)
    private String trait;
    @NotBlank
    @Column(length = 60)
    private String quality;
}
