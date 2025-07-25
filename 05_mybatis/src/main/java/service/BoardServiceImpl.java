package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import dao.BoardDao;
import model.dto.BoardDTO;
import model.dto.UserDTO;

public class BoardServiceImpl implements BoardService {

  private BoardDao boardDao = BoardDao.getInstance();
  
  @Override
  public ActionForward getBoards(HttpServletRequest request) {
    String sort = request.getParameter("sort");
    if (sort == null || !(sort.equalsIgnoreCase("ASC") || sort.equalsIgnoreCase("DESC"))) {
       sort = "DESC";
    }
    
    List<BoardDTO> boards = boardDao.getBoards(sort);
    System.out.println("boards:" + boards);
    int boardCount = boardDao.getBoardCount();
    
    request.setAttribute("boards", boards);
    request.setAttribute("boardCount", boardCount);
   
    return new ActionForward("/view/board/list.jsp", false);
  }

  @Override
  public ActionForward findBoards1(HttpServletRequest request) {
    
    // target, query, beginDate, endDate를 받아서 Map 생성
    Map<String, Object> map = Map.of("target", request.getParameter("target"), "query", request.getParameter("query"), "beginDate", request.getParameter("beginDate"), "endDate", request.getParameter("endDate"));
    
    List<BoardDTO> foundBoards = boardDao.findBoards1(map);
    
    request.setAttribute("boards", foundBoards);
    
    return new ActionForward("/view/board/list.jsp", false);
  }

  @Override
  public ActionForward findBoards2(HttpServletRequest request) {
    // title, content, beginDate, endDate를 받아서 Map 생성
    Map<String, Object> map = Map.of("title", request.getParameter("title"), "content", request.getParameter("content"), "beginDate", request.getParameter("beginDate"), "endDate", request.getParameter("endDate"));
    
    List<BoardDTO> foundBoards = boardDao.findBoards2(map);
    request.setAttribute("boards", foundBoards);
    
    return new ActionForward("/view/board/list.jsp", false);
  }

  @Override
  public void removeBoards(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // 체크된 numbers 값 받기
    String[] numbers = request.getParameterValues("numbers");
    
    int count = boardDao.deleteBoards(numbers);
    System.out.println("삭제된 행의 개수: " + count);
    
    String msg = "삭제 성공";
    String view = "/board/list";
    if (count != numbers.length ) {
      msg = "삭제 실패";
    }
    
    
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();
  }

  @Override
  public void modifyBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int bid = Integer.parseInt(request.getParameter("bid"));
    
    // bid, title, content 받아서 boardDTO 객체 생성
    BoardDTO board = new BoardDTO(
        bid, 
        null, 
        request.getParameter("title"), 
        request.getParameter("content"), 
        null, 
        null);
    
    int count = boardDao.updateBoard(board);
    
    String msg = "수정 성공";
    String view = "/board/detail?bid="+bid + "&code=detail";
    if (count != 1 ) {
      msg = "수정 실패";
      view = "/board/modifyForm?bid="+ bid + "&code=modify";
    }
    
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();
  }
  
  @Override
  public void registBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    // uid, title, content
    String uid = request.getParameter("uid");
    UserDTO user = new UserDTO(Integer.parseInt(uid), null, null, null);
    BoardDTO board = new BoardDTO(0, user, request.getParameter("title"), request.getParameter("content"), null, null);
    System.out.println("board: " + board);
    int count = boardDao.insertBoard(board);
    System.out.println("count: " + count);
    
    String msg = "등록 성공";
    String view = "/board/list";
    if (count != 1 ) {
      msg = "등록 실패";
      view = "/board/registForm"; 
    }
    
    
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();
    
  }
  
  @Override
  public void removeBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }
    
    int count = boardDao.deleteBoardById(bid);
    
    String msg = "삭제 성공";
    String view = "/board/list";
    if (count != 1 ) {
      msg = "삭제 실패"; 
    }
    
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + msg + "')");
    out.println("location.href='" + request.getContextPath() + view + "'");
    out.println("</script>");
    out.close();
  }

  @Override
  public ActionForward getBoardById(HttpServletRequest request) {
    int bid = 0;
    try {
      bid = Integer.parseInt(request.getParameter("bid"));
    } catch (Exception e) {
      bid = 0;
    }
   
    // code
    String code = request.getParameter("code");
    if (!(code.equalsIgnoreCase("detail") || code.equalsIgnoreCase("modify"))) {
      code = "detail";
    }
    
    request.setAttribute("board", boardDao.getBoardById(bid));
    
    return new ActionForward("/view/board/" + code + ".jsp", false);
  }

}
