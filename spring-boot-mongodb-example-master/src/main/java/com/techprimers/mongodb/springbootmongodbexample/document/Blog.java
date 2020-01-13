package com.techprimers.mongodb.springbootmongodbexample.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Blog {

	
	// commentUserId[] will contain the list of users' userId who have commented into that post.
	
	
	
    @Id
    private Integer blogId;
    private String blogAuthorId;
    private String description;
    private String[] commentUserId;

    public Blog(Integer id, String blogAuthorId, String description, String[] commentUserId) {
        this.blogId = id;
        this.blogAuthorId = blogAuthorId;
        this.description = description;
        this.commentUserId = commentUserId;
    }

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogAuthorId() {
		return blogAuthorId;
	}

	public void setBlogAuthorId(String blogAuthorId) {
		this.blogAuthorId = blogAuthorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String[] commentUserId) {
		this.commentUserId = commentUserId;
	}

    
}
