package pl.basicstuff.dmcompanionapp.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<Player> findAllByUserIdOrderByIdDesc(Long userId) {
        return playerRepository.findAllByUserIdOrderByIdDesc(userId);
    }

    public Player findPlayerById(Long id) {
        return playerRepository.findPlayerById(id);
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }
}
