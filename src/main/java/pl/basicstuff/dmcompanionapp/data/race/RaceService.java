package pl.basicstuff.dmcompanionapp.data.race;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;

    public void saveRace(Race race) {
        raceRepository.save(race);
    }

    public void updateRace(Race race) {
        raceRepository.save(race);
    }

    public void deleteRace(Race race) {
        raceRepository.delete(race);
    }

    public List<Race> racesList() {
        return raceRepository.findAll();
    }

    public Race findRaceById(Long id) {
        return raceRepository.findRaceById(id);
    }
}
