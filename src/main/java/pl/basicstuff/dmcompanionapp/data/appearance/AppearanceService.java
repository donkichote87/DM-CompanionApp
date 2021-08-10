package pl.basicstuff.dmcompanionapp.data.appearance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AppearanceService {
    private final AppearanceRepository appearanceRepository;

    public void saveAppearance(Appearance appearance) {
        appearanceRepository.save(appearance);
    }

    public void updateAppearance(Appearance appearance) {
        appearanceRepository.save(appearance);
    }

    public void deleteAppearance(Appearance appearance) {
        appearanceRepository.delete(appearance);
    }

    public List<Appearance> appearancesList() {
        return appearanceRepository.findAll();
    }

    public Appearance findAppearanceById(Long id) {
        return appearanceRepository.findAppearanceById(id);
    }

    public Appearance getRandomAppearance() {
        Random random = new Random();
        List<Appearance> appearances = appearancesList();
        return appearances.get(random.nextInt(appearances.size()));
    }
}
