package pl.basicstuff.dmcompanionapp.data.ideal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IdealRepository extends JpaRepository<Ideal, Long> {
    Ideal findIdealById(Long id);

    List<Ideal> findIdealsByAlignmentContainsOrAlignmentContainsOrAlignmentContainsIgnoreCase(String alignment1, String alignment2, String alignment3);
}
