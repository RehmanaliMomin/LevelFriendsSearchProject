package com.techprimers.mongodb.springbootmongodbexample.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.mongodb.springbootmongodbexample.document.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<String> getAllLevelledUser(String userId, int level){

		List<String> frndList=new ArrayList<String>();

		List<User> users=userRepository.findByUserId(userId);					
		User user = users.get(0);
		frndList=user.getFirstLevelFrnds();											//returns the first level friends of the user
		Set<String> result = new HashSet<String>(frndList);
		
		//to keep track of the users already taken into account for levels lesser then the target level
		Set<String> visitedUsers = new HashSet<String>(result);
		visitedUsers.add(userId);

		for(int i = 1; i<level; i++) {							
			HashSet<String> set = new HashSet<String>();
			for(String st : result) {
				User u = userRepository.findByUserId(st).get(0);
				set.addAll(u.getFirstLevelFrnds());
			}
			set.removeAll(result);
			set.removeAll(visitedUsers);

			result = new HashSet<>(set);
			visitedUsers.addAll(result);
			if(result.size()==0) return new ArrayList<String>(result);
		}
		
		return new ArrayList<String>(result);
	}

}
