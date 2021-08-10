package pl.basicstuff.dmcompanionapp.data.occupation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface OccupationRepository extends JpaRepository<Occupation, Long> {

    Occupation findOccupationById(Long id);
}
