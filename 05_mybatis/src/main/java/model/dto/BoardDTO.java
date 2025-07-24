package model.dto;

import java.sql.Timestamp;

public class BoardDTO {
  private int bid;
  private UserDTO user;
  private String title;
  private String content;
  private Timestamp created_at;
  private Timestamp modified_at;
  
  public BoardDTO() {
    
  }

  public BoardDTO(int bid, UserDTO user, String title, String content) {
    super();
    this.bid = bid;
    this.user = user;
    this.title = title;
    this.content = content;
  }

  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "BoardDTO [bid=" + bid + ", user=" + user + ", title=" + title + ", content=" + content + "]";
  }
}
