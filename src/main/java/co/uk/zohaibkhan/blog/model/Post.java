package co.uk.zohaibkhan.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Table(name = "post")
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name = "post_id")
  private Long id;

//  @Column(name = "title", nullable = false)
//  @Length(min = 5, message = "*Your title must have at least 5 characters")
//  @NotEmpty(message = "*Please provide title")
  private String title;
//
//  @Column(name = "body", columnDefinition = "TEXT")
//  private String body;
//
//  @Temporal(TemporalType.TIMESTAMP)
//  @Column(name = "create_date", nullable = false, updatable = false)
//  @CreationTimestamp
//  private Date createDate;
//
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getTitle() {
//    return title;
//  }
//
//  public void setTitle(String title) {
//    this.title = title;
//  }
//
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
}