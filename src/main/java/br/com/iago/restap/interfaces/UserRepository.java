package br.com.iago.restap.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.iago.restap.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u from user username")
	User findByUsername(@Param("userName") String userName);
}
