package pl.basicstuff.dmcompanionapp.name;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = Name.TABLE_NAME)
public class Name {
    public static final String TABLE_NAME = "names";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String name;
    private char sex;


}
