package co.uk.zohaibkhan.blog.service;

import co.uk.zohaibkhan.blog.model.Post;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface PostService {

  Page<Post> findAllOrderedByDatePageable(int page);

  void delete(Post post);

  Post save(Post post);

  Optional<Post> findForId(Long id);
}
