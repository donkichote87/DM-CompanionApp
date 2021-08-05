package pl.basicstuff.dmcompanionapp.data.firstname;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<FirstName> findAllByRaceAndSex(String race, char sex) {
        return firstNameRepository.findAllByRaceAndSex(race, sex);
    }

    public FirstName findNameById(Long id) {
        return firstNameRepository.findFirstNameById(id);
    }

}
