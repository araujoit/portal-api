package br.com.araujoit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.araujoit.entities.Post;
import br.com.araujoit.helpers.DatetimeHelper;
import br.com.araujoit.repositories.PostRepository;

@Service
public class PostService implements DatetimeHelper {

	@Autowired
	PostRepository postRepository;

	public Iterable<Post> listAll() {
		return postRepository.findAll();
	}
	
	public Optional<Post> getById(Long id) {
		return postRepository.findById(id);
	}

	public Post put(Post post) {
		post.setUpdatedAt(now());
		return postRepository.save(post);
	}

	public void deleteById(Long postId) {
		if (postId > 0) {
			postRepository.findById(postId).ifPresent(post -> {
				postRepository.delete(post);
			});
		}
	}
}
