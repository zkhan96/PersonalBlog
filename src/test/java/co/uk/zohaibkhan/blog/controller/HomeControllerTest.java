package co.uk.zohaibkhan.blog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import co.uk.zohaibkhan.blog.model.Post;
import co.uk.zohaibkhan.blog.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

  private MockMvc mockMvc;

  @Mock
  private PostService postService;

  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(postService)).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  public void testGetPostReturnsCorrectPost() throws Exception {
    Post post = new Post("title");
    post.setId(1L);
    when(postService.findForId(post.getId())).thenReturn(Optional.of(post));

    MvcResult result = mockMvc.perform(get(URI.create("/posts/" + post.getId())))
        .andExpect(status().isOk())
        .andReturn();

    assertEquals(post, objectMapper.readValue(result.getResponse().getContentAsString(), Post.class));
  }


}