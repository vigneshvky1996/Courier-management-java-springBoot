package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository

public interface BookCourierRepository extends JpaRepository<BookCourier, Integer> {
	
//	public BookCourier save(int id, String sName, String Snumber, String pickup, String rName, String rNumber, String delivery,
//			String status1, int bookid, String username);
	@Query(value = "insert into bookCourier (id, sName, sNumber,pickup, rName, rNumber, delivery, status1,bookid, username) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
	public BookCourier saveAll(int id, String sName, String sNumber, String pickup, String rName, String rNumber,
			String delivery, String status1, int bookid, String username);
	
//	List<BookCourier> findByUsername(String username);
	List<BookCourier> findAllByUsername(String username);
//	public BookCourier findByBookid1(int bookid);
	List<BookCourier> findByBookid(int bookid);
	
}
