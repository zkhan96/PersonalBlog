package co.uk.zohaibkhan.blog.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Post {

  public Post(String title) {
    this.title = title;
  }

  public Post() {
  }

  @Id
  @GeneratedValue
  private Long id;

//  @Column(name = "title", nullable = false)
//  @Length(min = 5, message = "*Your title must have at least 5 characters")
//  @NotEmpty(message = "*Please provide title")
  private String title;
//
//  @Column(name = "body", columnDefinition = "TEXT")
//  private String body;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createDate;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

//  public String getBody() {
//    return body;
//  }
//
//  public void setBody(String body) {
//    this.body = body;
//  }
//
//  public Date getCreateDate() {
//    return createDate;
//  }
//
//  public void setCreateDate(Date date) {
//    this.createDate = date;
//  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Post post = (Post) o;
    return Objects.equals(id, post.id) &&
        Objects.equals(title, post.title);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, title);
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", title='" + title + '\'' +
        '}';
  }
}