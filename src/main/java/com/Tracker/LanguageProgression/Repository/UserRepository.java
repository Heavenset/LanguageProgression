package com.Tracker.LanguageProgression.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Tracker.LanguageProgression.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
