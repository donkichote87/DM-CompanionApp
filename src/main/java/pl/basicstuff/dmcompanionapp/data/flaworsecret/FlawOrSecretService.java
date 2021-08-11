package pl.basicstuff.dmcompanionapp.data.flaworsecret;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.talent.Talent;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FlawOrSecretService {
    private final FlawOrSecretRepository flawOrSecretRepository;
    public void saveFlawOrSecret(FlawOrSecret flawOrSecret) {
        flawOrSecretRepository.save(flawOrSecret);
    }

    public void updateFlawOrSecret(FlawOrSecret flawOrSecret) {
        flawOrSecretRepository.save(flawOrSecret);
    }

    public void deleteFlawOrSecret(FlawOrSecret flawOrSecret) {
        flawOrSecretRepository.delete(flawOrSecret);
    }

    public List<FlawOrSecret> flawsOrSecretsList() {
        return flawOrSecretRepository.findAll();
    }

    public FlawOrSecret findFlawOrSecretById(Long id) {
        return flawOrSecretRepository.findFlawOrSecretById(id);
    }

    public FlawOrSecret getRandomFlawOrSecret() {
        Random random = new Random();
        List<FlawOrSecret> flawsOrSecrets = flawsOrSecretsList();
        return flawsOrSecrets.get(random.nextInt(flawsOrSecrets.size()));
    }
}
