package dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dto.BoardDTO;

public class BoardDao {
  
  private SqlSessionFactory factory;
  
  private BoardDao() {
    try {
      InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static BoardDao dao = new BoardDao();
  public static BoardDao getInstance() {
    return dao;
  }  
  
  // boardMapper.xml의 namespace
  String namespace = "mybatis.boardMapper.";
  
  
  public List<BoardDTO> getBoards(String sort) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "getBoards" , sort);
    ss.close();
    return boards;
  }
  
  public BoardDTO getBoardById(int bid) {
    SqlSession ss = factory.openSession();
    BoardDTO board = ss.selectOne(namespace + "getBoardById", bid);
    ss.close();
    return board;
  }
  
  public int getBoardCount() {
    SqlSession ss = factory.openSession();
    int boardCount = ss.selectOne(namespace + "getBoardCount");
    ss.close();
    return boardCount;
  }
  
  public List<BoardDTO> findBoardsUsingQuery(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "findBoardsUsingQuery", map);
    ss.close();
    return boards;
  }
  
  
  public List<BoardDTO> findBoardsUsingDate(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "findBoardsUsingDate", map);
    ss.close();
    return boards;
  }
  
  public List<BoardDTO> findBoards1(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "findBoards1", map);
    ss.close();
    return boards;
  }
  
  public List<BoardDTO> findBoards2(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<BoardDTO> boards = ss.selectList(namespace + "findBoards2", map);
    ss.close();
    return boards;
  }
  
  public int insertBoard(BoardDTO board) {
    SqlSession ss = factory.openSession(false); // auto commit이 아닌 상태 (수동 커밋으로 설정)
    int count = ss.insert(namespace + "insertBoard", board);
    if (count  == 1) {
      ss.commit(); // 성공 시 수동으로 커밋하기
    }
    ss.close();
    return count;
  }
  
  // 수정
  public int updateBoard(BoardDTO board) {
    SqlSession ss = factory.openSession(false);
    int count = ss.update(namespace + "updateBoard", board);
    if (count == 1) {
      ss.commit();
    }
    ss.close();
    return count;
  }

  // 삭제
  public int deleteBoardById(int bid) {
    SqlSession ss = factory.openSession(false);
    int count = ss.update(namespace + "deleteBoardById", bid);
    if (count == 1) {
      ss.commit();
    }
    ss.close();
    
    return count;
  }
  
  // 목록 삭제
  public int deleteBoards(String[] bidArray) {
    SqlSession ss = factory.openSession(false);
    int count = ss.update(namespace + "deleteBoards", bidArray);
    if (count == bidArray.length) {
      ss.commit();
    }
    ss.close();
    return count;
  }
}
