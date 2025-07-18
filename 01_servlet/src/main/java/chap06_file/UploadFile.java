package chap06_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadFile")
@MultipartConfig(
    location = "D:/storage", // 업로드 파일을 저장할 디렉터리 경로
    maxFileSize = 1024 * 1024 * 10 // 크기를 10MB 제한
)
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  File dir = new File("D:/storage");
	  
	  if (!dir.exists()) {
	    dir.mkdirs();
	  }
	 
	  Part part = request.getPart("file");
		String filename = System.currentTimeMillis() + "_" + part.getSubmittedFileName(); // 타임스탬프 + 밑줄 +  첨부된 파일명
	  part.write(filename);
	  
	  response.setHeader("Content-Type", "text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("<button id=\"back-btn\">back</button>");
    out.println("<script>");
    out.println(" const backBtn  = document.getElementById('back-btn');\r\n"
        + "  backBtn.addEventListener('click', (e) => {\r\n"
        + "    history.back();\r\n"
        + "  });");
    out.println("</script>");
	  out.println("<div>첨부된파일정보");
	  out.println("<div>원래파일명: " + part.getSubmittedFileName() );
	  out.println("<div>저장된파일명: " + filename + "</div>");
	  out.println("<hr>");
	  
	  // 업로드 디렉터리에 저장된 모든 파일 가져와서 응답
	  out.println("<div>저장된 파일 목록</div>");
	  File[] files = dir.listFiles();
	  for (File file : files) {
	    String storedFilename = file.getName(); // 타임스탬프 + 밑줄 +  첨부된 파일명
	    String originFilename = storedFilename.substring(storedFilename.indexOf("_") + 1); // 첨부된 파일명
	    out.println("<div><a href=\"/01_servlet/DownLoad?filename=" + URLEncoder.encode(storedFilename, "UTF-8") + "\">" +originFilename + "</a></div>"); 
	  }
	 
	
	  out.close();
	}

}
