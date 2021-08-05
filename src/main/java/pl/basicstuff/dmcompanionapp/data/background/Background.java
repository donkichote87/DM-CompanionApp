package pl.basicstuff.dmcompanionapp.data.background;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = Background.TABLE_NAME)
public class Background {
    public static final String TABLE_NAME = "backgrounds";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String name;
}
