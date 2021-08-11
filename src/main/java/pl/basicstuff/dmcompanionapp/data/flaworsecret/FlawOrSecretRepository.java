package pl.basicstuff.dmcompanionapp.data.flaworsecret;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FlawOrSecretRepository extends JpaRepository<FlawOrSecret, Long> {

    FlawOrSecret findFlawOrSecretById(Long id);
}
