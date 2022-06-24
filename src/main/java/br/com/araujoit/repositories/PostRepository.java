package br.com.araujoit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.araujoit.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
