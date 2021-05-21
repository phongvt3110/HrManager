package castisvn.repository;

import org.springframework.stereotype.Repository;

import castisvn.entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
