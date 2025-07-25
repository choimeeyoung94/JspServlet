package dao;

import java.util.List;
import java.util.Map;

import model.dto.BoardDTO;
import model.dto.UserDTO;

public class Main {
  public static void main(String[] args) {
    
    //UserDao dao = UserDao.getInstance();
    //System.out.println(dao.getUser(new UserDTO(0, "shark@gmail.com", "shark", null)));
    
    BoardDao bdao = BoardDao.getInstance();
    //String sort = "DESC";
   // for (BoardDTO board : bdao.getBoards(sort)) {
     // System.out.println(board);
    //}
    
    //System.out.println("count: " + bdao.getBoardCount());
    
    Map<String, Object> map = Map.of("target", "content", "query", "입니다.");
    
    //List<BoardDTO> boards = bdao.findBoardsUsingQuery(map);
    //System.out.println("검색 결과: " + boards);
    
//   // Map<String, Object> map2 = Map.of("beginDate", "2025-07-24", "endDate", "2025-07-24");
//   // for (BoardDTO foundBoard : bdao.findBoardsUsingDate(map2)) {
//   //   System.out.println("검색결과: " + foundBoard);
//  //  }
//    
   /*
    * Map<String, Object> map3 = Map.of("target","created_at", "query", "입니다",
    * "beginDate", "2025-07-24", "endDate", "2025-07-24"); for (BoardDTO foundBoard
    * : bdao.findBoards1(map3)) { System.out.println("검색결과: " + foundBoard); }
    */
    
   /*
    * Map<String, Object> map4 = Map.of("title","", "content", "상어", "beginDate",
    * "2025-07-24", "endDate", "2025-07-24"); for (BoardDTO foundBoard :
    * bdao.findBoards2(map4)) { System.out.println("검색결과: " + foundBoard); }
    */
    
    
   
    
    

  }
}
