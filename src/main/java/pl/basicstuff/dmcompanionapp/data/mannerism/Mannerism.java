package pl.basicstuff.dmcompanionapp.data.mannerism;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Mannerism.TABLE_NAME)
public class Mannerism {
    public static final String TABLE_NAME = "mannerisms";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String description;
}
