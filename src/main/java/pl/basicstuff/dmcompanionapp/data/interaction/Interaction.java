package pl.basicstuff.dmcompanionapp.data.interaction;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Interaction.TABLE_NAME)
public class Interaction {
    public static final String TABLE_NAME = "interactions";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 100, unique = true)
    private String interactionMale;
    @NotBlank
    @Column(length = 100, unique = true)
    private String interactionFemale;
}
