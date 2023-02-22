package com.tian.login_regis.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tian.login_regis.models.LoginUser;
import com.tian.login_regis.models.User;
import com.tian.login_regis.services.UserService;

@Controller
public class UserController {
    // Add once service is implemented:
     @Autowired
     private UserService userService;
	
    // private UserService userServ;
    
    @GetMapping("/")
    public String loginPage(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLoginUser", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	   User registeredUser=userService.register(newUser, result);
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLoginUser", new LoginUser());
            return "login.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userID", registeredUser.getId());
        session.setAttribute("userName", registeredUser.getUserName());
        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLoginUser") LoginUser newLoginUser, 
            BindingResult result, Model model, HttpSession session) {
        	User loginUser=userService.login(newLoginUser, result);
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userID", loginUser.getId());
        session.setAttribute("userName", loginUser.getUserName());
        return "redirect:/welcome";
    }
    @GetMapping("/welcome")
    public String weolcome(HttpSession session) {
    	if(session.getAttribute("userID")==null) {
    		return "redirect:/";  		
    	}
        return "welcome.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	 session.invalidate();
    	 return "redirect:/";
    }

}
