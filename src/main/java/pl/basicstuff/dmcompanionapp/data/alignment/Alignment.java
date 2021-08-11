package pl.basicstuff.dmcompanionapp.data.alignment;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Alignment.TABLE_NAME)
public class Alignment {
    public static final String TABLE_NAME = "alignments";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String nature;
}
