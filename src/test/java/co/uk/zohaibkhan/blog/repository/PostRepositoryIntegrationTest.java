package co.uk.zohaibkhan.blog.repository;


import static org.junit.Assert.assertEquals;

import co.uk.zohaibkhan.blog.PersonalBlogApplication;
import co.uk.zohaibkhan.blog.config.SecurityConfig;
import co.uk.zohaibkhan.blog.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersonalBlogApplication.class, SecurityConfig.class})
@DataJpaTest
public class PostRepositoryIntegrationTest {

  @Autowired
  private PostRepository postRepository;

  @Test
  public void testSavingWorks() {
    Post post = new Post("titlehehe");
    postRepository.save(post);

    assertEquals(post, postRepository.findById(post.getId()).orElse(null));
  }
}