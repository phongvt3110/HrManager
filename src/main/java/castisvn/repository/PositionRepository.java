package castisvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import castisvn.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

}
