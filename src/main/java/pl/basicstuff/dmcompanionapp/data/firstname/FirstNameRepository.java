package pl.basicstuff.dmcompanionapp.data.firstname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FirstNameRepository extends JpaRepository<FirstName, Long> {


    List<FirstName> findAllByRaceAndSex(String race, String sex);

    FirstName findFirstNameById(Long id);
}