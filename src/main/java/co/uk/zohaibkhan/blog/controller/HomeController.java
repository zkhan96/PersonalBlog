package co.uk.zohaibkhan.blog.controller;

import co.uk.zohaibkhan.blog.model.Post;
import co.uk.zohaibkhan.blog.service.PostService;
import co.uk.zohaibkhan.blog.util.Pager;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  private final PostService postService;

  @Autowired
  public HomeController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/")
  public String home(@RequestParam(defaultValue = "0") int page,
      Model model) {
    Page<Post> posts = postService.findAllOrderedByDatePageable(page);
    Pager pager = new Pager(posts);
    model.addAttribute("pager", pager);
    return "index";
  }

  @GetMapping("/posts/{postId}")
  public ResponseEntity<Post> getPostById(@PathVariable String postId) {
    Optional<Post> post = postService.findForId(Long.parseLong(postId));
    return post.map(p -> ResponseEntity.ok().body(p))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPost(@RequestBody String title) {
    Post post = new Post(title);
    postService.save(post);
    LOGGER.debug("Saved post: {}", post);
    return ResponseEntity.ok(title);
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }
}
