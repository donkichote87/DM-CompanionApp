package pl.basicstuff.dmcompanionapp.data.lastname;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;


import java.util.List;

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

}
