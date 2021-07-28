package pl.basicstuff.dmcompanionapp.npc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NpcService {
    private final NpcRepository npcRepository;

    public List<Npc> findNpcsByUserId(Long userId) {
        return npcRepository.findNpcsByUserIdOrderByIdDesc(userId);
    }

    public Npc findNpcById(Long id) {
        return npcRepository.findNpcById(id);
    }

    public void saveNpc(Npc npc) {
        npcRepository.save(npc);
    }

    public void updateNpc(Npc npc) {
        npcRepository.save(npc);
    }

    public void deleteNpc(Npc npc) {
        npcRepository.delete(npc);
    }
}
