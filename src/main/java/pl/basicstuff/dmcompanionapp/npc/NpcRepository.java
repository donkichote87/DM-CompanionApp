package pl.basicstuff.dmcompanionapp.npc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NpcRepository extends JpaRepository<Npc, Long> {

    List<Npc> findNpcsByUserIdOrderByIdDesc(Long userId);
    Npc findNpcById(Long id);
}
