package pl.basicstuff.dmcompanionapp.data.alignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AlignmentService {
    private final AlignmentRepository alignmentRepository;

    public void saveAlignment(Alignment alignment) {
        alignmentRepository.save(alignment);
    }

    public void updateAlignment(Alignment alignment) {
        alignmentRepository.save(alignment);
    }

    public void deleteAlignment(Alignment alignment) {
        alignmentRepository.delete(alignment);
    }

    public List<Alignment> alignmentsList() {
        List<Alignment> alignmentsList = alignmentRepository.findAll();
        Collections.sort(alignmentsList, (a1, a2)-> (int) (a1.getId()- a2.getId()));
        return alignmentsList;
    }

    public Alignment findAlignmentById(Long id) {
        return alignmentRepository.findAlignmentById(id);
    }

    public String getRandomAlignment() {
        Random random = new Random();
        List<Alignment> alignments = alignmentsList();

        return alignments.get(random.nextInt(alignments.size())).getNature();
    }
}
