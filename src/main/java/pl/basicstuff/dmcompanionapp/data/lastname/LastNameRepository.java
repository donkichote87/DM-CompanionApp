package pl.basicstuff.dmcompanionapp.data.lastname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LastNameRepository extends JpaRepository<LastName, Long> {


    List<LastName> findAllByRace(String race);

    LastName findLastNameById(Long id);
}