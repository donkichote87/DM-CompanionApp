package pl.basicstuff.dmcompanionapp.data.characterclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterClassService {
    private final CharacterClassRepository characterClassRepository;

    public void saveClass(CharacterClass characterClass) {
        characterClassRepository.save(characterClass);
    }

    public void updateClass(CharacterClass characterClass) {
        characterClassRepository.save(characterClass);
    }

    public void deleteClass(CharacterClass characterClass) {
        characterClassRepository.delete(characterClass);
    }

    public List<CharacterClass> classesList() {
        return characterClassRepository.findAll();
    }

    public CharacterClass findCharacterClassById(Long id) {
        return characterClassRepository.findCharacterClassById(id);
    }
}
