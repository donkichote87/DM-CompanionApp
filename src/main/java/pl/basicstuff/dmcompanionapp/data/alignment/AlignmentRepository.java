package pl.basicstuff.dmcompanionapp.data.alignment;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AlignmentRepository extends JpaRepository<Alignment, Long> {
    Alignment findAlignmentById(Long id);


}
