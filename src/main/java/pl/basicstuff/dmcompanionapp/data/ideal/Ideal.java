package pl.basicstuff.dmcompanionapp.data.ideal;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = Ideal.TABLE_NAME)
        public class Ideal {
    public static final String TABLE_NAME = "ideals";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 60, unique = true)
    private String name;
    @NotBlank
    @Column(length = 60)
    private String alignment;
}
