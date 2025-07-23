package model.dto;

import java.sql.Timestamp;

public class BoardDTO {
  private int bid;
  private UserDTO user;  //------------ uid, nickname 관리
  private String title;
  private String content;
  private Timestamp createdAt;  //----- MySQL's TIMESTAMP 타입은 java.sql.Timestamp 클래스 타입으로 처리합니다.
  private Timestamp modifiedAt;
  
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
  public Timestamp getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }
  public Timestamp getModifiedAt() {
    return modifiedAt;
  }
  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }
  @Override
  public String toString() {
    return "BoardDTO [bid=" + bid + ", user=" + user + ", title=" + title + ", content=" + content + ", createdAt="
        + createdAt + ", modifiedAt=" + modifiedAt + "]";
  }
}
