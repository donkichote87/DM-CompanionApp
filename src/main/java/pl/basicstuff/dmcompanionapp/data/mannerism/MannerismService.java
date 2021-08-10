package pl.basicstuff.dmcompanionapp.data.mannerism;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.talent.Talent;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MannerismService {
    private final MannerismRepository mannerismRepository;

    public void saveMannerism(Mannerism mannerism) {
        mannerismRepository.save(mannerism);
    }

    public void updateMannerism(Mannerism mannerism) {
        mannerismRepository.save(mannerism);
    }

    public void deleteMannerism(Mannerism mannerism) {
        mannerismRepository.delete(mannerism);
    }

    public List<Mannerism> mannerismsList() {
        return mannerismRepository.findAll();
    }

    public Mannerism findMannerismById(Long id) {
        return mannerismRepository.findMannerismById(id);
    }

    public Mannerism getRandomMannerism() {
        Random random = new Random();
        List<Mannerism> mannerisms = mannerismsList();
        return mannerisms.get(random.nextInt(mannerisms.size()));
    }
}
