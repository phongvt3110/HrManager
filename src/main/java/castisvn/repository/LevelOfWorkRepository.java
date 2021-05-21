package castisvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import castisvn.entities.LevelOfWork;

@Repository
public interface LevelOfWorkRepository extends JpaRepository<LevelOfWork, Integer>{

}
