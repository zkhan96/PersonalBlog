package co.uk.zohaibkhan.blog.service.impl;

import co.uk.zohaibkhan.blog.model.Post;
import co.uk.zohaibkhan.blog.repository.PostRepository;
import co.uk.zohaibkhan.blog.service.PostService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public Optional<Post> findForId(Long id) {
    return postRepository.findById(id);
  }

  @Override
  public Page<Post> findAllOrderedByDatePageable(int page) {
    return postRepository.findAllByOrderByCreateDateDesc(PageRequest.of(subtractPageByOne(page),5));
  }

  @Override
  public Post save(Post post) {
    return postRepository.save(post);
  }

  @Override
  public void delete(Post post) {
    postRepository.delete(post);
  }

  private int subtractPageByOne(int page) {
    return page < 1 ? 0 : page - 1;
  }

}
