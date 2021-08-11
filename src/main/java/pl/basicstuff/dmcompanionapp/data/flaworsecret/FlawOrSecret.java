package pl.basicstuff.dmcompanionapp.data.flaworsecret;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = FlawOrSecret.TABLE_NAME)
public class FlawOrSecret {
    public static final String TABLE_NAME = "flawsOrSecrets";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true, length = 191)
    private String description;
}
