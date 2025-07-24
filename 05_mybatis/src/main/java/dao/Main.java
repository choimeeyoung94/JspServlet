package dao;

import model.dto.UserDTO;

public class Main {
  public static void main(String[] args) {
    
    UserDao dao = UserDao.getInstance();
    System.out.println(dao.getUser(new UserDTO(0, "shark@gmail.com", "shark", null)));
    
    
    
    
  }
}
