package pl.basicstuff.dmcompanionapp.data.mannerism;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MannerismRepository extends JpaRepository<Mannerism, Long> {

    Mannerism findMannerismById(Long id);
}
