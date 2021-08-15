package pl.basicstuff.dmcompanionapp.player;

import lombok.Data;
import pl.basicstuff.dmcompanionapp.data.alignment.Alignment;
import pl.basicstuff.dmcompanionapp.data.background.Background;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClass;
import pl.basicstuff.dmcompanionapp.data.race.Race;
import pl.basicstuff.dmcompanionapp.user.User;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = Player.TABLE_NAME)
@Data
public class Player {
    public static final String TABLE_NAME = "players";
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
    @NotNull
    @ManyToOne
    private Race race;
    @NotNull
    @ManyToOne
    private CharacterClass characterClass;
    @NotNull
    @ManyToOne
    private Background background;
    @NotBlank
    @Column(length = 50)
    private String alignment;
    private int strengthAbility;
    private int dexterityAbility;
    private int conditionAbility;
    private int intelligenceAbility;
    private int wisdomAbility;
    private int charismaAbility;
    private int hp;

    @Pattern(regexp = "^[kK][0-9]{1,2}", message = "{hp.dice}")
    private String hpDice;
    @Size(max = 255)
    private String flaw;
    @Size(max = 255)
    private String ideal;
    @Size(max = 255)
    private String bond;
    @Size(max = 255)
    private String personalityTraits;
    @Lob
    @Size(max = 600)
    private String history;
    @Lob
    @Size(max = 600)
    private String equipment;
    @Lob
    @Size(max = 600)
    private String proficienciesAndLanguages;
    @Lob
    @Size(max = 600)
    private String featuresAndTraits;
    @Lob
    @Size(max = 600)
    private String skills;
    @ManyToOne
    private User user;


}
