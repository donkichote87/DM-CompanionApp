package pl.basicstuff.dmcompanionapp.data.race;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RaceRepository extends JpaRepository<Race, Long> {
    Race findRaceById(Long id);
}
