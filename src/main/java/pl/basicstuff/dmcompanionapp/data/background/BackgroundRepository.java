package pl.basicstuff.dmcompanionapp.data.background;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BackgroundRepository extends JpaRepository<Background, Long> {
    Background findBackgroundById(Long id);
}
