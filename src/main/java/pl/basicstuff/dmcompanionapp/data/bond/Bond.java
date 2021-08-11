package pl.basicstuff.dmcompanionapp.data.bond;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Bond.TABLE_NAME)
public class Bond {
    public static final String TABLE_NAME = "bonds";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String description;
}
