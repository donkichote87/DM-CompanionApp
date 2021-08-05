package pl.basicstuff.dmcompanionapp.data.background;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BackgroundService {
    private final BackgroundRepository backgroundRepository;

    public void saveBackground(Background background) {
        backgroundRepository.save(background);
    }

    public void updateBackground(Background background) {
        backgroundRepository.save(background);
    }

    public void deleteBackground(Background background) {
        backgroundRepository.delete(background);
    }

    public List<Background> backgroundsList() {
        return backgroundRepository.findAll();
    }

    public Background findBackgroundById(Long id) {
        return backgroundRepository.findBackgroundById(id);
    }
}
