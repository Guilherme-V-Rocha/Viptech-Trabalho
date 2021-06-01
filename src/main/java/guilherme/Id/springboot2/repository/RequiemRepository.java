package guilherme.Id.springboot2.repository;

import guilherme.Id.springboot2.domain.Requiem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequiemRepository extends JpaRepository<Requiem, Long> {
    List<Requiem> findByName(String name);
}
