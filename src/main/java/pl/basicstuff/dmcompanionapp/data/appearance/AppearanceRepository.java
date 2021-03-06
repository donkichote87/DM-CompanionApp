package pl.basicstuff.dmcompanionapp.data.appearance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppearanceRepository extends JpaRepository<Appearance, Long> {

    Appearance findAppearanceById(Long id);
}
