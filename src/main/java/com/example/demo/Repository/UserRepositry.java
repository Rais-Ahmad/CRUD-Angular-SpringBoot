package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepositry extends JpaRepository<User, Long> {
	
	User findByEmail(@Param(value = "email") String email);

	List<User> findAllByVerificationStatus(boolean status);

	Optional<User> findByCnic(String cnic);

	Optional<User> findByCnicAndDegree(String cnic, String degree);

	List<User> findAllByOrderByDateDesc();

	List<User> findAllByClassSection(String classSection);
	
    Optional<User> findByEmailAndPassword(String email, String password);
	
	User findByIdAndEmailTokenAndSmsToken(long id, int emailToken, int smsToken);

}
