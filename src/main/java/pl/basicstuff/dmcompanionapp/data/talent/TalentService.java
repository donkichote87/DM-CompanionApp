package pl.basicstuff.dmcompanionapp.data.talent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TalentService {
    private final TalentRepository talentRepository;
    public void saveTalent(Talent talent) {
        talentRepository.save(talent);
    }

    public void updateTalent(Talent talent) {
        talentRepository.save(talent);
    }

    public void deleteTalent(Talent talent) {
        talentRepository.delete(talent);
    }

    public List<Talent> talentsList() {
        return talentRepository.findAll();
    }

    public Talent findTalentById(Long id) {
        return talentRepository.findTalentById(id);
    }

    public Talent getRandomTalent() {
        Random random = new Random();
        List<Talent> talents = talentsList();
        return talents.get(random.nextInt(talents.size()));
    }
}
