package com.example.demo;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="bookcourier")
public class BookCourier {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String sname;
	String snumber;
	String pickup;
	String rname;
	String rnumber;
	String delivery;
	String status1;
//	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookid;
	String username;
	
	public BookCourier(int id, String sName, String sNumber, String pickup, String rName, String rNumber,
			String delivery, String status1, int bookid, String username) {
		super();
		this.id = id;
		this.sname = sName;
		this.snumber = sNumber;
		this.pickup = pickup;
		this.rname = rName;
		this.rnumber = rNumber;
		this.delivery = delivery;
		this.status1 = status1;
		this.bookid = bookid;
		this.username = username;
	}
	
	public BookCourier() {
		
	}
	
	
	
	public BookCourier(int bookid) {
		super();
		this.bookid = bookid;
	}

	public BookCourier(String username) {
		super();
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sname;
	}
	public void setsName(String sName) {
		this.sname = sName;
	}
	public String getsNumber() {
		return snumber;
	}
	public void setsNumber(String sNumber) {
		this.snumber = sNumber;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getrName() {
		return rname;
	}
	public void setrName(String rName) {
		this.rname = rName;
	}
	public String getrNumber() {
		return rnumber;
	}
	public void setrNumber(String rNumber) {
		this.rnumber = rNumber;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
