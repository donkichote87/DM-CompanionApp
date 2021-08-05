package pl.basicstuff.dmcompanionapp.data.firstname;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = FirstName.TABLE_NAME)
public class FirstName {
    public static final String TABLE_NAME = "first_names";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String name;
    private char sex;
    private String race;


}
