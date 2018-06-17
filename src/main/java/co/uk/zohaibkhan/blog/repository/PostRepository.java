package co.uk.zohaibkhan.blog.repository;

import co.uk.zohaibkhan.blog.model.Post;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findById(Long id);

  Page<Post> findAllByOrderByCreateDateDesc(Pageable Pageable);
}
