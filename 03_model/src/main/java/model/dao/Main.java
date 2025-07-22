package model.dao;

import java.util.List;

import model.dto.BoardDTO;
import model.dto.UserDTO;

public class Main {
  public static void main(String[] args) {

    BoardDAO dao = BoardDAO.getInstance();

    List<BoardDTO> boards = dao.getBoards();
    System.out.println(boards.size());
    System.out.println(boards);

    BoardDTO board = dao.getBoardBy(1);
    System.out.println(board);

    UserDTO user = new UserDTO();
    user.setUid(1);
    BoardDTO b = new BoardDTO();
    b.setUser(user);
    b.setTitle("신규제목");
    b.setContent("신규내용");
    if (dao.insertBoard(b) == 1) {
      System.out.println("등록 성공");
    } else {
      System.out.println("등록 실패");
    }
    
    int bid = 1;
    if (dao.deleteBoard(bid) == 1) {
      System.out.println("삭제 성공");
    } else {
      System.out.println("삭제 실패");
    }

    
  }
}
