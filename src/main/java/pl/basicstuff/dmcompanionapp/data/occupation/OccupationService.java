package pl.basicstuff.dmcompanionapp.data.occupation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OccupationService {
    private final OccupationRepository occupationRepository;

    public void saveOccupation(Occupation occupation) {
        occupationRepository.save(occupation);
    }

    public void updateOccupation(Occupation occupation) {
        occupationRepository.save(occupation);
    }

    public void deleteOccupation(Occupation occupation) {
        occupationRepository.delete(occupation);
    }

    public List<Occupation> occupationsList() {
        return occupationRepository.findAll();
    }

    public Occupation findOccupationById(Long id) {
        return occupationRepository.findOccupationById(id);
    }

    public Occupation getRandomOccupation() {
        Random random = new Random();
        List<Occupation> occupations = occupationsList();
        return occupations.get(random.nextInt(occupations.size()));
    }
}
