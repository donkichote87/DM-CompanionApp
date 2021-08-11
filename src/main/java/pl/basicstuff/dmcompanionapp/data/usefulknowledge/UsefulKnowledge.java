package pl.basicstuff.dmcompanionapp.data.usefulknowledge;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = UsefulKnowledge.TABLE_NAME)
public class UsefulKnowledge {
    public static final String TABLE_NAME = "useful_knowledge";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 150, unique = true)
    private String description;
}
