package pl.basicstuff.dmcompanionapp.data.race;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = Race.TABLE_NAME)
public class Race {
    public static final String TABLE_NAME = "races";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String generalRace;
    @Column(length = 60, unique = true)
    private String subRace;

}
