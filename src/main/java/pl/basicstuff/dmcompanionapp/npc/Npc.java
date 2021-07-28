package pl.basicstuff.dmcompanionapp.npc;

import lombok.Data;
import pl.basicstuff.dmcompanionapp.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = Npc.TABLE_NAME)
@Data
public class Npc {
    public static final String TABLE_NAME = "npcs";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp = "[MF]", message = "{choose.sex}")
    @Column(length = 1)
    private String sex;
    @NotBlank
    @Column(length = 50)
    private String name;
    @NotBlank
    @Column(length = 50)
    private String race;
    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String occupation;
    @Lob
    @Size(max = 600)
    private String history;
    @Lob
    @Size(max = 600)
    private String appearance;
    @Lob
    @Size(max = 600)
    private String abilities;
    @Lob
    @Size(max = 600)
    private String talent;
    @Lob
    @Size(max = 600)
    private String mannerism;
    @Lob
    @Size(max = 600)
    private String interaction;
    @Lob
    @Size(max = 600)
    private String usefulKnowledge;
    @Size(max = 255)
    private String flawOrSecret;
    @Size(max = 255)
    private String ideal;
    @Size(max = 255)
    private String bond;

    @ManyToOne
    private User user;

}
