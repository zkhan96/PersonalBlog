package co.uk.zohaibkhan.blog.controller;

import co.uk.zohaibkhan.blog.model.Post;
import co.uk.zohaibkhan.blog.service.PostService;
import co.uk.zohaibkhan.blog.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }
}
