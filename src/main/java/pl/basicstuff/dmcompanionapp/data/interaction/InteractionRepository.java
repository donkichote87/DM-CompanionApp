package pl.basicstuff.dmcompanionapp.data.interaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    Interaction findInteractionById(Long id);
}
