package pl.basicstuff.dmcompanionapp.data.lastname;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = LastName.TABLE_NAME)
public class LastName {
    public static final String TABLE_NAME = "last_names";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String name;
    private String race;


}
