package br.com.araujoit.services;

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
