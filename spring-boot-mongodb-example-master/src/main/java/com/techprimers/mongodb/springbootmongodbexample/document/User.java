package com.techprimers.mongodb.springbootmongodbexample.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	
	//firstLevelFriends will contain the list of first level friends.
	//when the user (x-userId) comments on a post, the list of userids of the commentUserId is fetched, and then for each of those userIds, x is
	//added to their friendlist and for x, all those userIds are added to its friends list.

	@Id
	private String userId;
	private String name;

	

	public List<String> getFirstLevelFrnds() {
		return firstLevelFrnds;
	}

	public void setFirstLevelFrnds(List<String> firstLevelFrnds) {
		this.firstLevelFrnds = firstLevelFrnds;
	}

	private List<String> firstLevelFrnds;

	

	public User(String userId, String name, List<String> firstLevelFrnds) {
		super();
		this.userId = userId;
		this.name = name;
		this.firstLevelFrnds = firstLevelFrnds;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
