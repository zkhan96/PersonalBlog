package co.uk.zohaibkhan.blog.repository;

import co.uk.zohaibkhan.blog.model.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
//
//  Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);
//
  Optional<Post> findById(Long id);
}
