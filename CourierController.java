package com.example.demo;
//import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourierController {
	
	@Autowired
	LoginRepository repo;
	

	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	
	@RequestMapping("/login")
	public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session) {
		
		Login login= repo.findByUsernameAndPassword(username, password);
		if(login!= null) {
			session.setAttribute("username", username);
			return"loginHome.html";
		}
		else {
			return"home.html";
		}
	//	return null;
	}
	
	@GetMapping("/newuser")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("newUserForm");
		Login login = new Login();
		mav.addObject("user",login);
		return mav;
	}
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Login user) {
		repo.save(user);
		return"home.html";
		
	}
	@RequestMapping("/logout")
	public String logoutPage() {
		return"home.html";
	}
	
	@RequestMapping("/bookNew")
	public String bookNew() {
		return"bookNewCourierForm.html";
	}
	
	
	
	/*
	@RequestMapping("/book")
	public String bookCourier1(@RequestParam("sName") String sName , @RequestParam("sNumber") String sNumber,@RequestParam("pickUp") String pickup , 
			@RequestParam("rName") String rName ,@RequestParam("rNumber") String rNumber , 
			@RequestParam("delivery") String delivery ,@RequestParam("username") String username , @RequestParam("status") String status1,HttpSession session) {
		
		Random rand = new Random();
		int bookid = rand.nextInt(1000);
		int id= rand.nextInt(50);
		
		BookCourier bookCourier = repo1.saveAll(id, sName, sNumber,pickup, rName, rNumber, delivery, status1,bookid,username);
		if(bookCourier != null) {
			return"loginHome.html";
		}
		else {
			return null;
		}
		
	} */
	
	
}
