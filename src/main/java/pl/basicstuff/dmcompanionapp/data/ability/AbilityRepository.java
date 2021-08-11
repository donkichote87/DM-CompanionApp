package pl.basicstuff.dmcompanionapp.data.ability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findAbilityById(Long id);
    List<Ability> findAbilitiesByQuality(String quality);
    List<Ability> findAbilitiesByQualityAndTraitNotLike(String quality, String trait);
}
