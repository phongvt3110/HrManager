package castisvn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import castisvn.entities.UserRole;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{	
}
