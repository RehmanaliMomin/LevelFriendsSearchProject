package com.techprimers.mongodb.springbootmongodbexample.resource;

import com.techprimers.mongodb.springbootmongodbexample.document.DemoUser;
import com.techprimers.mongodb.springbootmongodbexample.document.User;
import com.techprimers.mongodb.springbootmongodbexample.repository.UserRepository;
import com.techprimers.mongodb.springbootmongodbexample.repository.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UserRepository userRepository;
    
    @Autowired
    UserService userService;
    
    

    public UsersResource(UserRepository userRepository,UserService userService) {
        this.userRepository = userRepository;
        this.userService=userService;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    @GetMapping(value="/users/{userId}/level/{levelNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getUserOfLevel(@PathVariable String userId, @PathVariable Integer levelNo){
    	return userService.getAllLevelledUser(userId, levelNo);
    }
    
    
    
}
