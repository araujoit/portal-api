package br.com.araujoit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.araujoit.entities.Post;
import br.com.araujoit.services.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping(produces = "text/plain")
	public String get() {
		return "Post Controller";
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<?> listAll() {		
		return ResponseEntity.ok(postService.listAll());
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Post> create(@RequestBody Post post) {
		final Post savedPost = postService.put(post);
		return new ResponseEntity(savedPost, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
		postService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
