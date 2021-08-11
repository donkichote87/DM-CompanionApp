package pl.basicstuff.dmcompanionapp.data.ideal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class IdealService {
    private final IdealRepository idealRepository;

    public void saveIdeal(Ideal ideal) {
        idealRepository.save(ideal);
    }

    public void updateIdeal(Ideal ideal) {
        idealRepository.save(ideal);
    }

    public void deleteIdeal(Ideal ideal) {
        idealRepository.delete(ideal);
    }

    public List<Ideal> idealsList() {
        return idealRepository.findAll();
    }

    public Ideal findIdealById(Long id) {
        return idealRepository.findIdealById(id);
    }

    public String getRandomIdeal(String ideal) {
        Random random = new Random();
        String[] alignments = ideal.split(" ");

        List<Ideal> ideals;
        if (alignments.length > 1) {
            ideals = idealRepository.findIdealsByAlignmentContainsOrAlignmentContainsOrAlignmentContainsIgnoreCase(alignments[0], alignments[1], "inny");
        } else {
            ideals = idealRepository.findIdealsByAlignmentContainsOrAlignmentContainsOrAlignmentContainsIgnoreCase(alignments[0], " ", "inny");
        }
        return ideals.get(random.nextInt(ideals.size())).getName();


    }
}
