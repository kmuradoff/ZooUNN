package az.prompt.zoounn.repository;

import az.prompt.zoounn.model.AnimalJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalJpaRepository extends JpaRepository<AnimalJpa, Integer> {
}
