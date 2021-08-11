package pl.basicstuff.dmcompanionapp.data.bond;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BondRepository extends JpaRepository<Bond, Long> {

    Bond findBondById(Long id);
}
