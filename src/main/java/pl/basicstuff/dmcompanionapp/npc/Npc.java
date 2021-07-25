package pl.basicstuff.dmcompanionapp.npc;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Npc.TABLE_NAME)
@Data
public class Npc {
    public static final String TABLE_NAME = "npcs";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 50)
    private String name;
    @NotNull
    @Column(length = 50)
    private String sex;
    @NotNull
    @Column(length = 50)
    private String race;
    @Size(max = 600)
    @Column(length = 600)
    private String description;
    @Size(max = 600)
    @Column(length = 600)
    private String personality;
    @Size(max = 600)
    @Column(length = 600)
    private String history;
    @Size(max = 600)
    @Column(length = 600)
    private String motivation;
    @Size(max = 50)
    @Column(length = 50)
    private String occupation;
    @Size(max = 50)
    @Column(length = 50)
    private String flaws;
    @Size(max = 50)
    @Column(length = 50)
    private String ideals;
    @Column(length = 50)
    private String bonds;
    @Column(length = 100)
    private String secret;

}
