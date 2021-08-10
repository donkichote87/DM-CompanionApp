package pl.basicstuff.dmcompanionapp.data.firstname;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.lastname.LastName;
import pl.basicstuff.dmcompanionapp.data.race.Race;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FirstNameService {
    private final FirstNameRepository firstNameRepository;



    public void saveName(FirstName name) {
        firstNameRepository.save(name);
    }

    public List<FirstName> listOfNames() {
        return firstNameRepository.findAll();
    }

    public void deleteName(FirstName name) {
        firstNameRepository.delete(name);
    }

    public void updateName(FirstName name) {
        firstNameRepository.save(name);
    }
    public List<FirstName> findAllByRaceAndSex(String race, String sex) {
        return firstNameRepository.findAllByRaceAndSex(race, sex);
    }

    public FirstName findNameById(Long id) {
        return firstNameRepository.findFirstNameById(id);
    }

    public FirstName getRandomFirstName(Race race, String sex) {
        Random random = new Random();
        if (race.getGeneralRace().equals("Półelf")) {
            Stream<FirstName> namesStream = Stream
                    .of(findAllByRaceAndSex("Człowiek", sex), findAllByRaceAndSex("Elf", sex))
                    .flatMap(Collection::stream);
            List<FirstName> names = namesStream.collect(Collectors.toList());
            return names.get(random.nextInt(names.size()));
        }else {
            List<FirstName> names = findAllByRaceAndSex(race.getGeneralRace(), sex);
            return names.get(random.nextInt(names.size()));
        }
    }
}
