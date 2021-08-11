package pl.basicstuff.dmcompanionapp.data.ability;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public void saveAbility(Ability ability) {
        abilityRepository.save(ability);
    }

    public void updateAbility(Ability ability) {
        abilityRepository.save(ability);
    }

    public void deleteAbility(Ability ability) {
        abilityRepository.delete(ability);
    }

    public List<Ability> abilitiesList() {
        return abilityRepository.findAll();
    }

    public Ability findAbilityById(Long id) {
        return abilityRepository.findAbilityById(id);
    }
    public List<Ability> findAbilitiesByQuality(String quality) {
        return abilityRepository.findAbilitiesByQuality(quality);
    }
    public List<Ability> findAbilitiesByQualityAndTraitNotLike(String quality, String trait) {
        return abilityRepository.findAbilitiesByQualityAndTraitNotLike(quality, trait);
    }

    public String getRandomAbility(String sex) {
        Random random = new Random();
        List<Ability> goodAbilities = findAbilitiesByQuality("Wysoka");
        Ability goodAbility = goodAbilities.get(random.nextInt(goodAbilities.size()));
        List<Ability> badAbilities = findAbilitiesByQualityAndTraitNotLike("Niska", goodAbility.getTrait());
        Ability badAbility = badAbilities.get(random.nextInt(badAbilities.size()));
        if (sex.equals("M")) {
            return goodAbility.getTrait() + " - " + goodAbility.getDescriptionMale()
                    + "\n" + badAbility.getTrait() + " - " + badAbility.getDescriptionMale();
        } else {
            return goodAbility.getTrait() + " - " + goodAbility.getDescriptionFemale()
                    + "\n" + badAbility.getTrait() + " - " + badAbility.getDescriptionFemale();
        }
    }
}
