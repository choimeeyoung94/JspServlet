package dao;

import java.sql.Connection;
import java.util.List;

import model.dto.BoardDTO;

public interface BoardDao {
  Connection getConnection();
  void close();
  
  List<BoardDTO> getBoards();
  BoardDTO getBoardBy(int bid);
  int insertBoard(BoardDTO board);
  int deleteBoard(int bid);
  int updateBoard(BoardDTO board);
}
