## SpringBoard분석

### 1. sql 자료구조 분석

~~~sql
CREATE TABLE board (
	id INT AUTO_INCREMENT UNIQUE, #id는 게시판 고유번호, 유니크, 0 넣으면 알아서 증가
    writer VARCHAR(30) NOT NULL, # writer : 작성자
    title VARCHAR(200) NOT NULL, # 제목
    content TEXT,                # 내용
    view_cnt INT DEFAULT 0,      # 조회수. 나중에 상세보기하면 1증가, 수정하면 아니야
    reg_date TIMESTAMP DEFAULT now(), #현재 시간이 default로 돼, 읽을 때 date로..
    file_name VARCHAR(50),       # 파일 이름, 같은 파일이 있으면 어떻게?
    file_uri VARCHAR(500),       # 같은 이름이여도 uri 경로가 다르면 okay - UUID 활용!!
								 # Hash함수의 결과인 비둘기집을 등록!    
    PRIMARY KEY (id)              
);

# User 라는 클래스를 받으면 결국 안에 seq있으니까 이를 활용할 수 있다고!
CREATE TABLE b_user (
    seq INT AUTO_INCREMENT,         # sequence, 그냥 고유키 번호
    id VARCHAR(30) NOT NULL UNIQUE,  # id : 유저 아이디, 고유해야함
    pw VARCHAR(64) NOT NULL,         # pw : 비밀번호, 그냥저장하면 위험, 
    								
    username VARCHAR(30) NOT NULL,   # 사용자 이름
    PRIMARY KEY(seq) 
);
~~~

---

### 2. DTO 분석

DTO는 sql 데이터를 담을 자료구조, 변수명을 정말 조심하자.

#### Board.java

- 변수명 : id, writer, title, content, viewCnt, regDate, fileName, fileUri
- viewCnt, regDate, fileName, fileUri가 다 다르네 ? -> mapper에서  resultMap을 등록하여 반환받자.



#### User.java

- 변수명 : seq, id, pw, username

- 여긴 다른거 없으니 편하게 들어가자

---

### 3. BOARD 분석 : DAO 분석 - mapper 분석 - service - Controller - view

DAO는 DB에 직접 왔다갔다'만' 하는 인터페이스(매퍼를 통해 메또드 구현),  

(interface - 3번 방식이기 떄문에 impl 필요 X)

#### 3.1.1 BoardDao.java

~~~ java
void updateBoard(Board board); // 기존게시판을 하나 입력받아서(가져와서) 수정
void deleteBoard(int id); // 고유값인 id를 통해 게시물 접근 -> 삭제
void insertBoard(Board board); // 게시판을 하나 입력받아 DB에 삽입
Board selectOne(int id); // 게시글 조회 : 고유값 id로 DB에 Board를 반환받는 메또드
List<Board> selectList(HashMap<String, String> params);
// Hashmap으로 받는 이유는, < "1", key>, <"2", key> <"3", key> 로 해당 조건 별로 원하는 내용을
// 가져올 수 있는 기능을 구현하기 위함, 전체 리스트를 가져오는데 조건문을 걸 수도 있다능!
~~~

#### 3.1.2. boardMapper.xml

~~~ xml
<!-- 매퍼에서 네임스페이스가 매우 중요! 빈으로 등록하면 알아서 챱챱 인터페이스랑 챱챱!!-->
<mapper namespace = "com.hamakim94.board.model.dao.BoardDao">
	<!-- 앙 변수명 달라? result맵을 이용해버리자 -->
    <resultMap type = "board" id = "boardMap"> <!-- type board : typeAlias 지정됐지?-->
        <id column ="id" property = "id"/><!-- 일반적으로 고유값은 id, 사실 result랑 똑같음-->
        <!-- 왼쪽이 sql column, 오른쪽이 DTO property -->
    	<result column="writer" property="writer"/>
  		<result column="title" property="title"/>
  		<result column="content" property="content"/>
  		<result column="view_cnt" property="viewCnt"/>
  		<result column="reg_date" property="regDate"/>
  		<result column="file_name" property="fileName"/>
  		<result column="file_uri" property="fileUri"/>
    </resultMap>
    <!-- 여기서 id 값은 인터페이스명이랑 일치하는 sense-->
    <insert id = "insertBoard" parameterType = "board">
        <!--고유값 id는 0 들어가면 알아서 AUTO INCREMENT, 변수명 쓰기 싫어서 다 받어(순서 중요)-->
        INSERT INTO board VALUES
        (0, #{writer},#{title}, #{content}, #{viewCnt}, now(), 
        #{fileName}, #{fileUri}) 
    </insert>
    
    <update id = "updateBoard" parameterType = "board">
        UPDATE board <!-- ID를 기준으로 접근할거야, 고유값이잖앙! -->
        SET
        title = #{title}, writer = #{writer}, content = #{content},
        view_cnt = #{viewCnt}, file_name = #{fileName}, file_uri = #{fileUri}
        WHERE id = #{id} 
    </update>
    <!-- 삭제는 함, 근데 그냥 삭제하면 돼? 웩! 그런 기능은 그냥 서르비스에서 구현하렴 -->
    <select id = "deleteBoard" parameterType = "int">
        DELETE FROM board WHERE id = #{id}
    </select>
    
    <!-- 넣기, 근데 변수들 다 가져오네? 리 절 트 맵 써 서 편 하 게 하 자 -->
    <!-- 정확히 하자. 반 환 타 입 이 board기 때문에 변수들 편하게 넣게 해주는게 리젙르맵!-->
	<select id ="selectOne" resultMap = "boardMap" parameterType = "int">
        SELECT id, title, writer, content, view_cnt, 
        date_format(reg_date, '%Y-%m-%d %H%i%s') as reg_date, file_name, file_uri
        FROM board
        WHERE id = #{id}
    </select>
    
    <!-- 중요, 사실 마이바티스는 if문. for문 넣을 수 있음. 돌 았 다 -->
    <!-- 더 나아가, hash맵으로 받았기에 키 값에 따라 내가 가져올 리스트들을 선 별 가 능 --> 
    <select id = "selectList", resultMap="boardMap", parameterType = "java.util.HashMap">
        SELECT id, title, writer, content, view_cnt, 
        date_format(reg_date, '%Y-%m-%d %H%i%s') as reg_date, file_name, file_uri
        FROM board
        <if test = 'mode==1'> <!-- 기억해둬 mode라는 값으로 판단하고 String으로 들어와도 ㅇㅋ-->
            WHERE title LIKE CONCAT('%', #{key}, '%') <!-- mode가 1이면 제목스 -->
        </if>
        <if test = 'mode==2'> 
            WHERE content LIKE '%${key}%'<!-- mode가 2이면 내용스 -->
        </if> <!-- $로 들어요면 문자 타입 그대로 가기 때문에 이렇게 써도 ok라고 함! -->
        
        <if test = 'mode==3'> 
            WHERE title LIKE CONCAT('%', #{key}, '%') <!-- mode가 1이면 제목|| 내용스 -->
            OR content LIKE '%${key}%'
        </if>
    </select>
</mapper>
~~~

#### 3.1.3. BoardService

서비스는 DB 접속해서 가져온 데이터를 토대로 가지고 놀기! update가 수정, select가 read, insert - Write!!

~~~ java
// BoardService.java 
public interface(BoardService){
    void writeBoard(Board board); // 글 쓰기, insert니 보드가 필요하겠지?
    void modifyBoard(Board board); // Board긴 한데, 쿼리스트링 id로 ${board.id} 쓰장!
    void deleteBoard(Board board); // 마찬가지로, 이미 상세 페이지에 있으니 id 써서 그거 지웡
    void updateCnt(int id); // 수정하는데 조회수 증가가 말이 됨? 그래서 아래에서 나눌게
    Board getBoardById(int id); // 수정할 때 게시판 자료 하나 가져오기. 너는 조회수 안 증가~
    Board readBoard(int id); // 누르면, 거기서 id값 있잖앙 그거 쓸거고, read니 조회수 증가~
    // 끼엑! 조건에 맞는걸 가져오기 위해 HashMap 썼엉! 그럼 여기서도 HashMap 써
    // 장점 : 어떤 글자가 포함된걸 가져올 때 , 그냥 여기에 key값으로 넘겨주면 알아서 <if> 돼
    List<Board> getBoardList(HashMap<String, String> params);
}
~~~

~~~java
// BoardServiceImpl      // 사실 @서르비스도 Component, 왜? is the Bean으로 등록!!! 
@Service("boardService") // 근데 이름 boardService로 정해줌. => AutoWired - 컨트롤러에서 사용!
public class BoardServiceImpl implements BoardService{
    @Autowired                        //가능한 이유가 뭐게
    private BoardDao boardDao;        // root-context에서 bean으로 등록해버렸 기 떄 문 에 !
    
    @Override 
	public void writeBoard(Board board) {
		boardDao.insertBoard(board); // controller에서, 입력 폼에서 데이터 맞춰서 주겠지 ㅎㅎ
	}
    @Override    //이미 상세 페이지에 있음, 수정 버튼 누르기 -> queryString id값 받아옴
	public void modifyBoard(Board board) {    // 대충 입벌려서 새로운 board 만들어줌
		Board originBoard = boardDao.selectOne(board.getId()); // 해당 id로 원본 가져옴
		originBoard.setTitle(board.getTitle());     // board는 페이지에서 입력된 새 board
		originBoard.setContent(board.getContent()); // 그래서 get을 통해 데이터 가져와서 set!
		boardDao.updateBoard(originBoard);   // 그리고 원본을 제목과 내용이 바뀐걸로 수정!     
	}
    
    @Override
    public void deleteBoard(int id){ // id 알아서 넣어주고
        Board board = boardDao.selectOne(id); // 해당 id값으로 board 가져와서
        if(board.getFileUri() != null){  // 파일uri, 경로에 파일이 뭔가 있으면!
            new File(board.getFileUri()).delete(); // 그 파일 지워~
        }
        boardDao.deleteBoard(id); // 그 다음 dao를 통해 DB에서 지워~
    }
    
    @Override // 생각 :user에는 seq로 이름 다르게 쓴 이유가, 입벌리면 알아서 넣어주기 때문에?!?!?!
    public void updateCnt(int id){ // 그래서 DTO에 있는 id랑 변수명을 일 치 시 킨 건 가 ?!?!?
                                 // controller에서 보니 atag로 id값 넣어서 모델에 줌,, 끽?
        Board board = boardDao.selectOne(id); // 클릭 시 그 id에 맞는 board 가져와
        board.setViewCnt(board.getViewCnt() + 1); // 그거 viewCnt 1 더해
        boardDao.updateBoard(board);             // 업데이트까지 해줘~
    }
    
    @Override // 그냥 읽기. 컨트롤러에서 상세 페이지로 가는 부분이겠지? 반환 타입이 board네
    public Board getBoardById(int id){
        this.updateCnt(id); // 이 this는 boardService, 위 메또드를 활용해 조회수 증가 해버리기~
        return boardDao.selectOne(id); // 그 다음에 가져오면 조회수 증가된 채로 board 가져오네!
    } // 이를 활용해 제목 누르면 상세페이지로 가자!
    
    // 전체 게시판 불러오기
    @Override      // 나중에 컨트롤러에서 기본값 공백으로 주기 문에.. 그냥 전체 리스트 가져와짐
    public List<Board> getBoardList(HashMap<String, String> params){ 
        // 파라미터를 넣는다면 결과 반환이 다르겠징?
        return boardDao.selectList(params);
    }
}
~~~

#### 3.1.4. servlet-context & root-context

왜 나눠 ? servletContext는 하나의 Dispatcher servlet. 대충 서블릿은 여기서 컴포넌트 스캔으로 가져올거고

root-context는 그 외 데이터랑 상호작용하는 것s, 여기서 bean으로 이것저것 등록s!!

##### servletContext

- 컨택스트 컴포넌트 스캔으로 controller 아래 있는거 싹 다 빈으로 만들어

##### root-context

- 컴포넌트 캔으로 서르비스들 싹 다 빈으로 만들어
- 근디.. mybatis도 빈으로 만들고 싶었지?
  - DriverManagerDataSource - 대충 JDBC에서 DB 연결하는 통로(설정들을 넣어주는 느낌?) 등록
  - 원래 application-context의 3대장, 뭐지? 머리 가슴 배 (개미)
    - typeAliases, environments, mapper
  - DriverManagerDataSource  : 가슴 담당(Environments)
  - 근데 교환할거잖아, 단위가 뭐야? session! (원래 try-catch로 Factory만들어서 session만들고..) 필요 없!
  - SqlSessionFactoryBean
    - 속성 : 머리가슴배,
      - 머리 :typeAliasesPackage :  value로 DTO 풀패키지명 적어!!
      - 가슴 :  dataSoruce 위에서 만든거 그냥 써!
      - 배 : mapperLocations
    - 

#### 3.1.5. BoardController & view

~~~java
@Controller// 이것도 하나의 빈으로 등록, Component에서 그냥 이름만 다른거! 
@RequestMapping("/board") // /(root context) /board 로 들어오면 여기로 들어오렴!
                      
public class BoardController{
    @Autowired // 입 벌 려 , 넣 어 줄 게 , 왜 ? @Service로 빈으로 등록했 기 때 문 에 
    private BoardService boardService;
    @Autowired // 이건 왜 가능 ? 자바 자체적으로 있는 객체를 스프링 방식으로 넣어줌
    private ServletContext servletContext; 
    
    @GetMapping("list") // 이렇개 하면 /root-context/board/list
    public String list(Model model, @RequestParam(defaultValue = "") String mode,
                       @ReqeustParam(defalutValue = "") String keyword){
        // 대충 아무거나 안 넣으면 초기값 ""를 통해서 HashMap에 아무것도 없어 <if> 안돌아감.
        
        HashMap<String, String> params = new HashMap<String, String>(); // 맹글어
        params.put("mode", mode); // list.jsp에서 폼 태그로, mode, 입력값인 keyword 넣어줌
        params.put("key", keyword); // 여기서 key인 이유가 boardMapper에서 key로 썼기 때문
        
        List<Board> list = boardService.getBoardList(params); // params를 통해 list가져와
        model.addAttribute("list", list); // "list"라는 이름에 list를 넣어줘
        return "board/list"; // 여기서 ViewResolver에의해 WEB-INF/board/list.jsp로 가짐!
        // 그럼 해당 파일에는 <c:forEach>로 var = board, items = ${list}로 돌겠넹?  
    }       
    
    @GetMapping("writeForm")
    public String writeForm(){
        return "board/writeform"; // 열로가~
    }
    
    @PostMapping("write")
	public String write(Board board, MultipartFile upload_file) {
		if (upload_file.getSize() != 0) {
			// 원래 경로에서 뒤에 /file 경로 붙이기
			String uploadPath = servletContext.getRealPath("/file");
			// 해당 경로에 파일 넣기 위해 파일 이름 가져오고
			String fileName = upload_file.getOriginalFilename();
			// 이름이 같은 경우에 어떡할래. 그래서 고유한 UUID를 활용해서 이름을 정해줄래~
			String saveName = UUID.randomUUID() + "";

			// 아경로에 이 파일명으로 저장하기 위해 파일 객체를 만들었고.
			File target = new File(uploadPath, saveName);
			// 이 폴더가 없으면 만들어줘
			// uploadpath가 담겨있는 파일 객체를 만들었는데 폴더가 존재하고 
			if (!new File(uploadPath).exists()) {
				// 대충 폴더 만드샘. 폴더니까, 객체겠지? ㅋㅋ 
				new File(uploadPath).mkdirs();
			}

			try { // 첨부파일의 바이트 내용을 target에다 써낸다.
				FileCopyUtils.copy(upload_file.getBytes(), target);
				board.setFileName(fileName);
				board.setFileUri(target.getCanonicalPath()); // 쓸데없는거 뺀 절대경로.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boardService.writeBoard(board);
		// 여기서, redirect방식으로 /board/board/list로보내면 다시 이 서블릿으로 오고
		// mode, keyword가 defaultValue인 ""로 되기 때문에, params에 아무것도 안 들어와서 전체              리스트를 가져온다.
		return "redirect:/board/list";
		// forward(객체를 가진 상태에서 다른 페이지로) vs redirect(재시작, 가지고있는거 다 지워) 
		// '/'가 있으면 ViewResolver가 안해줌. => '/'가 있으면 서블릿 컨텍스트가 가로챔.
        
        @GetMapping("detail")// list.jsp에서 제목 a tag가 
                            //   /board/detail?id=${board.id}로 들어오니. : GET방식
	                        // 쿼리스트링  : key : id , value : ${board.id} 느낌. 
                            //그래서 int id 손을 벌림 => key를 가리키는 것! YEAH..
	public String detail(Model model, int id){
		Board board = boardService.readBoard(id); // board 가져와서, 만약 board자체의 id가 들어왔더면 이건 필요가 없겠지..
		model.addAttribute("board", board); // model 새로 가져온 board 객체를 넣어줘서
		return "board/detail"; // 디테일로 가렴(바로 /WEB-INF/......detail.jsp로 가!
	}
        
        // 이제 아래는 느낌 있곘죠?
        
    @GetMapping("updateForm")
	public String updateForm(Model model, int id) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/updateform"; 
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.deleteBoard(id);
		return "redirect:/board/list";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail?id=" + board.getId();
    }
}
~~~