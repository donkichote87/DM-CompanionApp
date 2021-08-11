package pl.basicstuff.dmcompanionapp.npc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.ability.AbilityService;
import pl.basicstuff.dmcompanionapp.data.alignment.AlignmentService;
import pl.basicstuff.dmcompanionapp.data.appearance.AppearanceService;
import pl.basicstuff.dmcompanionapp.data.bond.BondService;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstNameService;
import pl.basicstuff.dmcompanionapp.data.flaworsecret.FlawOrSecretService;
import pl.basicstuff.dmcompanionapp.data.ideal.IdealService;
import pl.basicstuff.dmcompanionapp.data.interaction.InteractionService;
import pl.basicstuff.dmcompanionapp.data.lastname.LastName;
import pl.basicstuff.dmcompanionapp.data.lastname.LastNameService;
import pl.basicstuff.dmcompanionapp.data.mannerism.MannerismService;
import pl.basicstuff.dmcompanionapp.data.occupation.OccupationService;
import pl.basicstuff.dmcompanionapp.data.race.Race;
import pl.basicstuff.dmcompanionapp.data.race.RaceService;
import pl.basicstuff.dmcompanionapp.data.talent.TalentService;
import pl.basicstuff.dmcompanionapp.data.usefulknowledge.UsefulKnowledgeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NpcService {
    private final NpcRepository npcRepository;
    private final FirstNameService firstNameService;
    private final LastNameService lastNameService;
    private final RaceService raceService;
    private final OccupationService occupationService;
    private final AppearanceService appearanceService;
    private final TalentService talentService;
    private final MannerismService mannerismService;
    private final InteractionService interactionService;
    private final BondService bondService;
    private final FlawOrSecretService flawOrSecretService;
    private final AbilityService abilityService;
    private final AlignmentService alignmentService;
    private final IdealService idealService;
    private final UsefulKnowledgeService usefulKnowledgeService;

    public List<Npc> findNpcsByUserId(Long userId) {
        return npcRepository.findNpcsByUserIdOrderByIdDesc(userId);
    }

    public Npc findNpcById(Long id) {
        return npcRepository.findNpcById(id);
    }

    public void saveNpc(Npc npc) {
        npcRepository.save(npc);
    }

    public void updateNpc(Npc npc) {
        npcRepository.save(npc);
    }

    public void deleteNpc(Npc npc) {
        npcRepository.delete(npc);
    }

    public Npc getRandomNpc(String sex) {
        Npc randomNpc = new Npc();

        Race race = raceService.getRandomRace();
        randomNpc.setRace(race.getSubRace());
        randomNpc.setSex(sex);

        FirstName firstName = firstNameService.getRandomFirstName(race, sex);
        LastName lastName = lastNameService.getRandomLastName(race);
        if (lastName != null) {
            randomNpc.setName(firstName.getName() + " " + lastName.getName());
        } else {
            randomNpc.setName(firstName.getName());
        }

        randomNpc.setAppearance(appearanceService.getRandomAppearance().getDescription());
        randomNpc.setTalent(talentService.getRandomTalent().getDescription());
        randomNpc.setMannerism(mannerismService.getRandomMannerism().getDescription());
        randomNpc.setBond(bondService.getRandomBond());
        randomNpc.setFlawOrSecret(flawOrSecretService.getRandomFlawOrSecret().getDescription());
        randomNpc.setAbilities(abilityService.getRandomAbility(sex));
        randomNpc.setOccupation(occupationService.getRandomOccupation(sex));
        randomNpc.setInteraction(interactionService.getRandomInteraction(sex));
        randomNpc.setAlignment(alignmentService.getRandomAlignment());
        randomNpc.setIdeal(idealService.getRandomIdeal(randomNpc.getAlignment()));
        randomNpc.setUsefulKnowledge(usefulKnowledgeService.getRandomUsefulKnowledge());
        randomNpc.setHistory("Użyj swojej wyobraźni :)");

        return randomNpc;
    }
}
