package com.tian.login_regis.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tian.login_regis.models.LoginUser;
import com.tian.login_regis.models.User;
import com.tian.login_regis.repositories.UserRepo;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> optionalUser=userRepo.findByEmail(newUser.getEmail());
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "Email alrdy registered!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "unique", "Password does not match!");   		
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        userRepo.save(newUser);
        return newUser;

    }
    public User login(LoginUser newLoginUser, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> optionalUser=userRepo.findByEmail(newLoginUser.getEmail());
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "Email not registered!");
    		return null;
    	}
    	
    	User user=optionalUser.get();
    	
    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}

        return user;
    }
}

