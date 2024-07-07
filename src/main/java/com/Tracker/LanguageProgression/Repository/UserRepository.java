package com.Tracker.LanguageProgression.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Tracker.LanguageProgression.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// Why not a user_name? cuz JPA is ignoring part after '_'
	User findByUserName(String userName);
}
