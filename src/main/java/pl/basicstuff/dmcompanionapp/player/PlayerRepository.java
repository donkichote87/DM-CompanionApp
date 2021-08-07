package pl.basicstuff.dmcompanionapp.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByUserIdOrderByIdDesc(Long userId);
    Player findPlayerById(Long id);
}
