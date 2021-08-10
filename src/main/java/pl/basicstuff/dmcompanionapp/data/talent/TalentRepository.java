package pl.basicstuff.dmcompanionapp.data.talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TalentRepository extends JpaRepository<Talent, Long> {

    Talent findTalentById(Long id);
}
