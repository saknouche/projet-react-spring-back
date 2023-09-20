package com.sadev.app.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.sadev.app.model.Comment;
import com.sadev.app.model.Post;

public class PostResponse {

	private Long id;
	private String username;
	private String imageUrl;
	private Long likes;
	private LocalDate createdAt;
	private List<Comment> comments;

	
	public PostResponse() {
		super();
	}

	public PostResponse(Long id, String username, String imageUrl, Long likes, LocalDate createdAt,
			List<Comment> comments) {
		super();
		this.id = id;
		this.username = username;
		this.imageUrl = imageUrl;
		this.likes = likes;
		this.createdAt = createdAt;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
