package pl.basicstuff.dmcompanionapp.data.usefulknowledge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsefulKnowledgeRepository extends JpaRepository<UsefulKnowledge, Long> {
    UsefulKnowledge findUsefulKnowledgeById(Long id);

}
