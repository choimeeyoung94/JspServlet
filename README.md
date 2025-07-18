# HttpServletResponse
- 서버가 클라이언트에게 HTTP 응답을 보낼 때 사용하는 객체
- 응답 메시지의 상태 코드, 응답 헤더, 응답 바디(본문)를 생성하거나 제어
- 주요 기능
1) HTTP 상태코드: 200, 404 등
2) 응답 헤더: Content-Type, Cache-Control 등
3) 응답 바디: HTML, JSON, XML 등
4) 추가 작업: Cookie, Redirect 등

# forward
- 현재 서블릿이 받은 클라이언트 요청(request)과 응답(response) 객체를 서버 내의 다른 리소스(서블릿)으로 그대로 전달하는 기능
- Request에 저장된 데이터(파라미터, 속성)도 함게 전달된다
- SELECT 문의 실행 결과를 전달하기 위해 forward를 활용한다
- 다른 페이지로의 이동도 forward를 활용한다
- 최초 요청 방식이 forward 할때 그대로 유지되기 때문에 doGet() 메소드가 받는다

# redirect
- 서버가 클라이언트에게 "새로운 주소로 다시 요청하세요"라고 지시하는 방식 (응답의 일종)
- redirect 지시를 받은 클라이언트는 다시 새로운 주소로 이동하므로 URL 변경을 확인할 수 있다
- 최초 요청 시 사용한 request와 response는 전달되지 않는다 (redirect는 별개의 새로운 요청이기 때문이다)
- redirect 시 다른 서버로 이동할 수 있다
- DB데이터 변경 작업(UPDATE, INSERT, DELETE) 이후 redirect 이동으로 새로 고침으로 인한 중복 제출(서브밋) 등을 방지할 수 있다
- PRG(Post-Redirect-Get) 패턴에 필수적인 역할을 수행 ( redirect 이후 이동은 다 get 방식 )

# JSON 객체 응답 예제
```


 // Java 객체( Map)
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("title", "파묘");
	  map.put("actors", Arrays.asList("김고은", "이도현", "최민식", "유해진"));
	  map.put("stars", 9.5);
	  map.put("info", Map.of("director", "장지헌", "genre", "스릴러"));   
	  
	  
	  // JSON 문자열
	  Gson gson = new Gson();
	  String json = gson.toJson(map);
	  
	  // 응답 만들기 (헤더, 바디 전송)
	  response.setHeader("Content-Type", "application/json; charset=UTF-8");
	  
	  PrintWriter out = response.getWriter();
	  out.write(json);
	  out.close();
```

# xml 응답 예제
```
	  // 전국 주요 도시 날씨 현황(1시간마다 자동 갱신)
	    String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
	    
	    // 접속 링크 생성
	    URL url = new URL(apiURL);
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    
	    // 문자 기반 입력 스트림 선언
	    BufferedReader in = null;
	    
	    // API 응답 결과에 따른 입력 스트림 in 생성
	    if (con.getResponseCode() == 200) {
	      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    } else {
	      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	    
	    // 한 줄씩 읽어 (String line) 모으기(StringBuilder sb)
	    String line = null;
	    StringBuilder sb = new StringBuilder();
	    while ((line = in.readLine()) != null) {
	      sb.append(line);
	    }
	    
	    // 사용이 끝난 입력 스트림 닫기
	    in.close();
	    
	    // StringBuilder sb에 저장된 내용을 응답
	    response.setHeader("Content-Type", "application/xml;charset=UTF-8");
	    
	    PrintWriter out = response.getWriter();
	    out.write(sb.toString());
	    out.close();
```