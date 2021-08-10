package pl.basicstuff.dmcompanionapp.data.interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InteractionService {
    private final InteractionRepository interactionRepository;

    public void saveInteraction(Interaction interaction) {
        interactionRepository.save(interaction);
    }

    public void updateInteraction(Interaction interaction) {
        interactionRepository.save(interaction);
    }

    public void deleteInteraction(Interaction interaction) {
        interactionRepository.delete(interaction);
    }

    public List<Interaction> interactionsList() {
        return interactionRepository.findAll();
    }

    public Interaction findInteractionById(Long id) {
        return interactionRepository.findInteractionById(id);
    }

    public Interaction getRandomInteraction() {
        Random random = new Random();
        List<Interaction> interactions = interactionsList();
        return interactions.get(random.nextInt(interactions.size()));
    }
}
