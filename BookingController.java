package com.example.demo;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
	
	@Autowired
	BookCourierRepository repo;
	
	
	
	/*
	@RequestMapping("/book")
	public String bookCourier1(@RequestParam("sName") String sName , @RequestParam("sNumber") String sNumber,@RequestParam("pickUp") String pickup , 
			@RequestParam("rName") String rName ,@RequestParam("rNumber") String rNumber , 
			@RequestParam("delivery") String delivery ,@RequestParam("username") String username , @RequestParam("status") String status1,HttpSession session) {
		
		Random rand = new Random();
		int bookid = rand.nextInt(1000);
		int id= rand.nextInt(50);
		
		BookCourier bookCourier = repo.saveAll(id, sName, sNumber,pickup, rName, rNumber, delivery, status1,bookid,username);
	//	BookCourier bookCourier = new BookCourier(id, sName, sNumber,pickup, rName, rNumber, delivery, status1,bookid,username);
		repo.save(bookCourier);
		if(bookCourier != null) {
			return"loginHome.html";
		}
		else {
			return null;
		}
		
		return "loginHome.html";
	}  	*/
	@RequestMapping("/book")
	public String bookCourier1(@RequestParam("sName") String sName , @RequestParam("sNumber") String sNumber,@RequestParam("pickUp") String pickup , 
			@RequestParam("rName") String rName ,@RequestParam("rNumber") String rNumber , 
			@RequestParam("delivery") String delivery ,@RequestParam("username") String username , @RequestParam("status") String status1,HttpSession session) {
		
		Random rand = new Random();
		int bookid = rand.nextInt(1000);
		int id= rand.nextInt(50);
		BookCourier bookcourier= new BookCourier(id,sName,sNumber,pickup,rName,rNumber,delivery,status1,bookid,username);
		repo.save(bookcourier);
		return"loginHome.html";
	}
	
	@RequestMapping("/viewMyBooking")
	public String viewbookings() {
		return "getUserName.html";
	}
	
	@RequestMapping("/viewMyBookings")
	public String viewmybookings(@RequestParam("username") String username, Model model) {
//		List<BookCourier> bookcourier =  new ArrayList<>();
//		repo.findAllByUsername(username).forEach(bookcourier::add);
//		BookCourier bookcourier= new BookCourier(username);
//		Model model = model.addAttribute("bookings",this.repo.findAllByUsername(username));
		model.addAttribute("bookings",this.repo.findAllByUsername(username));
		return "viewbookings.html";
	}
	
	@RequestMapping("/searchByBookId")
	public String tracking(@RequestParam("bookid") int bookid, Model model) {
//		BookCourier bookcourier= repo.findByBookid1(bookid);
		model.addAttribute("bookings",this.repo.findByBookid(bookid));
	
			return"courierstatus.html";
		
	}
	

}
