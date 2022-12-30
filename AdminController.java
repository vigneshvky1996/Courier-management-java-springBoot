package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	AdminRepository repo;
	@Autowired
	BookCourierRepository repo1;
	
	@RequestMapping("/admin")
	public String admin() {
		return"adminhome.html";
	}
	
	@RequestMapping("/adminlogin")
	public String adminLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session) {
		
		Admin admin= repo.findByUsernameAndPassword(username, password);
		if(admin!= null) {
			session.setAttribute("username", username);
			return"adminloginHome.html";
		}
		else {
			return"adminhome.html";
		}
	}
	
	@RequestMapping("/viewallorders")
	public String allbookings(Model model) {
		
		model.addAttribute("orders",this.repo1.findAll());
		return "adminAllBookings.html";
	}
	
	@RequestMapping("/newadmin")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("newUserFormAdmin");
		Admin login = new Admin();
		mav.addObject("user",login);
		return mav;
	}
	
	@PostMapping("/saveadmin")
	public String saveUser(@ModelAttribute Admin user) {
		repo.save(user);
		return"adminhome.html";
		
	}
	@RequestMapping("/adminEdit/{bookid}")
	public String adminEdit(@PathVariable int bookid, Model model) {
		model.addAttribute("bookings",this.repo1.findByBookid(bookid));
		return"adminEditForm.html";
	
	}
	
	@RequestMapping("/edit/{bookid}")
	public String adminUpdate() {
		return"viewallorders";
	}

}
