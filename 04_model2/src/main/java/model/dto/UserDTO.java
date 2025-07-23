package model.dto;

public class UserDTO {
  private int uid;
  private String nickname;
  
  public int getUid() {
    return uid;
  }
  public void setUid(int uid) {
    this.uid = uid;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  @Override
  public String toString() {
    return "UserDTO [uid=" + uid + ", nickname=" + nickname + "]";
  }
}
