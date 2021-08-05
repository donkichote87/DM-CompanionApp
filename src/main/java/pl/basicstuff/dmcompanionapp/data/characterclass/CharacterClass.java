package pl.basicstuff.dmcompanionapp.data.characterclass;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = CharacterClass.TABLE_NAME)
public class CharacterClass {
    public static final String TABLE_NAME = "classes";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String name;
}
