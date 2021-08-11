package pl.basicstuff.dmcompanionapp.data.talent;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Talent.TABLE_NAME)
public class Talent {
    public static final String TABLE_NAME = "talents";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true, length = 191)
    private String description;
}
