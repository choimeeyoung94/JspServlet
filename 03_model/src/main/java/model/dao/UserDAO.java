package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.dto.BoardDTO;
import model.dto.UserDTO;

public class UserDAO {
  private static UserDAO dao = new UserDAO();
  
  private UserDAO() {
    
  }
  
  public static UserDAO getInstance() {
    return dao;
  }
  
  // 모든 메소드가 공통으로 사용할 필드
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  private String sql;
  
  public List<UserDTO> getUsers() {
    
    List<UserDTO> users = new ArrayList<UserDTO>();
    
    try {
      con = DBUtils.getConnection();
      sql = "SELECT uid, nickname FROM tbl_user";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        // DB에서 가져온 결과 rs
       
        int uid = rs.getInt(1);
        String nickname = rs.getString(2);
        
        // 결과 rs를 BoardDTO로 변환
       
        UserDTO user = new UserDTO();
        user.setUid(uid);
        user.setNickname(nickname);
        
        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return users;
    
    
    
    
    
  }
  
}
