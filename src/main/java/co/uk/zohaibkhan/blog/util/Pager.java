package co.uk.zohaibkhan.blog.util;

import co.uk.zohaibkhan.blog.model.Post;
import org.springframework.data.domain.Page;

public class Pager {

  private Page<Post> posts;

  public Pager(Page<Post> posts) {
    this.posts = posts;
  }

  public int getPageIndex() {
    return posts.getNumber();
  }
}
