package pl.basicstuff.dmcompanionapp.data.usefulknowledge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UsefulKnowledgeService {
    private final UsefulKnowledgeRepository usefulKnowledgeRepository;

    public void saveUsefulKnowledge(UsefulKnowledge usefulKnowledge) {
        usefulKnowledgeRepository.save(usefulKnowledge);
    }

    public void updateUsefulKnowledge(UsefulKnowledge usefulKnowledge) {
        usefulKnowledgeRepository.save(usefulKnowledge);
    }

    public void deleteUsefulKnowledge(UsefulKnowledge usefulKnowledge) {
        usefulKnowledgeRepository.delete(usefulKnowledge);
    }

    public List<UsefulKnowledge> usefulKnowledgeList() {
        return usefulKnowledgeRepository.findAll();
    }

    public UsefulKnowledge findUsefulKnowledgeById(Long id) {
        return usefulKnowledgeRepository.findUsefulKnowledgeById(id);
    }

    public String getRandomUsefulKnowledge() {
        Random random = new Random();
        List<UsefulKnowledge> usefulKnowledgeList = usefulKnowledgeList();
        return usefulKnowledgeList.get(random.nextInt(usefulKnowledgeList.size())).getDescription();
    }
}
