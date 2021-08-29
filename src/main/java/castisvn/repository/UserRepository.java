package castisvn.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import castisvn.entities.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.username = :username or u.email = :username")
	Optional<User> getUserByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User getUserByEmail(@Param("email") String email);
	
	@Query(value = "select user.* from user inner join daily_report on user.id = daily_report.user_id group by daily_report.user_id", nativeQuery = true)
	List<User> getListUsers();
}
