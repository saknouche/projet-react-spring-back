package com.sadev.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadev.app.model.Post;
import com.sadev.app.model.dto.PostResponse;
import com.sadev.app.repository.PostRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts() {

		List<PostResponse> postsDto = new ArrayList<>();
		List<Post> posts = postRepository.findAll();
		if (!posts.isEmpty()) {
			for (Post post : posts) {
				postsDto.add(new PostResponse(post.getId(), post.getUser().getUsername(), post.getImageUrl(),
						post.getLikes(), post.getCreatedAt(), post.getComments()));
			}
			return ResponseEntity.ok(postsDto);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
