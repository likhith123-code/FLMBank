package com.example.FlmBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FlmBank.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="select * from User where aadhaar = ?1",nativeQuery=true)
	User findByAadhaar(long aadhaarNumber);

}
