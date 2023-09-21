package com.sadev.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadev.app.model.Comment;
import com.sadev.app.model.Post;
import com.sadev.app.model.dto.CommentRequest;
import com.sadev.app.repository.CommentRepository;
import com.sadev.app.repository.PostRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;

	@PostMapping("/comment")
	public ResponseEntity<?> addComment(@RequestBody CommentRequest request) {
		try {
			Comment newComment = new Comment();
			if (request.getMessage() != null) {
				newComment.setMessage(request.getMessage());
			}
			if (request.getPostId() != null) {
				Post post = postRepository.findById(request.getPostId()).get();
				newComment.setPost(post);
			}
			commentRepository.save(newComment);
			return ResponseEntity.status(HttpStatus.CREATED).body(newComment);

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}

	}
	
	@DeleteMapping("/comments/{id}")
	public ResponseEntity<?> deleteCommentById(@PathVariable("id") Long id){
		if(id != null) {
			Comment commentToDelete = commentRepository.findById(id).get();
			commentRepository.delete(commentToDelete); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
