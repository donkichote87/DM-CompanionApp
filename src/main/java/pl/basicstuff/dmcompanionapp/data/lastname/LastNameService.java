package pl.basicstuff.dmcompanionapp.data.lastname;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;
import pl.basicstuff.dmcompanionapp.data.race.Race;


import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LastNameService {
    private final LastNameRepository lastNameRepository;


    public void saveName(LastName name) {
        lastNameRepository.save(name);
    }

    public List<LastName> listOfNames() {
        return lastNameRepository.findAll();
    }

    public void deleteName(LastName name) {
        lastNameRepository.delete(name);
    }

    public void updateName(LastName name) {
        lastNameRepository.save(name);
    }

    public List<LastName> findAllByRace(String race) {
        return lastNameRepository.findAllByRace(race);
    }

    public LastName findNameById(Long id) {
        return lastNameRepository.findLastNameById(id);
    }

    public LastName getRandomLastName(Race race) {
        Random random = new Random();
        if (race.getGeneralRace().equals("Półelf")) {
            Stream<LastName> namesStream = Stream
                    .of(findAllByRace("Człowiek"), findAllByRace("Elf"))
                    .flatMap(Collection::stream);
            List<LastName> names = namesStream.collect(Collectors.toList());
            return names.get(random.nextInt(names.size()));
        } else {
            List<LastName> names = findAllByRace(race.getGeneralRace());
            if (names.size() > 0) {
                return names.get(random.nextInt(names.size()));
            } else {
                return null;
            }

        }
    }
}
