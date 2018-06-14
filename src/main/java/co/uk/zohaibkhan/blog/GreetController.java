package co.uk.zohaibkhan.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetController {
  private static final Logger LOGGER = LoggerFactory.getLogger(GreetController.class);

  @GetMapping("/")
  public String home(@RequestParam(name = "name", required = false, defaultValue = "World")
      String name, Model model) {
    model.addAttribute("name", name);
    return "index";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }
}
