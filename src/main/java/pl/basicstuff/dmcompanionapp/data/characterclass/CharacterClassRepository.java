package pl.basicstuff.dmcompanionapp.data.characterclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {
    CharacterClass findCharacterClassById(Long id);
}
