package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
//	@Query("from user where username=?1 and password=?2")
	public Login findByUsernameAndPassword(String username, String password);
	
	

}
