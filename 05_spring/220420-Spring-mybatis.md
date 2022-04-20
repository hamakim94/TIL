# 22/04/20

### TCP/IP               TCP : 전화, UDP : 문자

- TCP/IP : 정보통신규약(약속을 제대로 해야힘)
- iHola : 올라(스페인어) 홀라(영어) 한국어 ???
  - 우리 이건 어떻게 통신을 하는지 약속하자!
  - 이걸 **프로토콜**이라고 한다
- 프로토콜 특 : 정해야 할 게 많음.
  - 물리적인 신호 어떻게 하자
  - 0은 전기가 안 흐르게, 1은 전기 흐르게!
  - 4개씩 끊어서 읽자!, 2개씩 끊어서 읽자! 
- TCP/IP
  - OSI 7계층 중 4계층
  - TCP : 직접연결전화선 : 한 번 연결 하면 그 곳으로만 슝슝 가고
  - UDP : 어딘가로 보내면 어떻게든 가겠지 해서 알아서 감..
- 문자 : 첫 번째 보낸 문자가 두 번째 보낸 문자보다 먼저 도착할 거란 보장이 없다.



- MySQL은 연결이 중요, 즉 TCP 방식으로 하고 있음.! 
  - **자바에서는 Connection(인터페이스)이라는 객체가 있음!!!!!!**

---

#### CF) http:// , https://, file:///

- /// 은 루트 경로이다(프로토콜임, 약속이라구.)

---

### Java JDBC

- 그냥 그렇구나 하고 넘어가기.. 이걸 spring에서 어떻게 잘 활용하는지

Connection 쓰는데, 이게 mysql 쓸거야! 라고 해야함

- ~~~java
  Private Connection conn; // 첫 단추 : MySQL과 연동하기 위한 Connection 객체를 만들기
  
  public void openConnection(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드
          conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?	    serverTimezone=UTC", "id", "pw"); 
          // jdbc 방식으로 mysql을 저 포트를 활용해서 어떤 거에 연결할거고 시간 맞추고 root/root라는걸 이용해서 확인
      }catch(ClassNotFoundException e){
          e.printStackTrace();
      }
  }
  ~~~
  
- ~~~java
  public void close(){   // 닫기.
      try{
          conn.close();
      } catch(SQLException e){
          e.printStackTrace();
      }
  }
  ~~~

- 한 번, DAO Interface를 구현한 Impl 객체에서 jdbc를 통해 접근해보자

- ~~~ java
  @Override
  public List<Student> selectAll(){
      
      List<Student> list = new ArrayList<Student>)();
      String sql = "SELECT * FROM student";
      Statement stmt = null; // 보내는 택배
      ResultSet rs = null; // 받는 택배 중 Select문만 사용
      try{
          stmt = conn.createStatement(); // 규격, 보내는이 , 받는 이
          rs.stmt.excuteQuery(sql);
          Student student = new Student(); // 레코드 하나 받기 위함
          while(rs.next()){ // 한 칸씩 내려가는 함수
              student.setSnum(rs.getInt(1)); // 몇 번쨰 친구가 어떤 타입으로 어디에 들어가야..
              student.setSname(rs.getString(2));
              student.setSgrade(rs.getInt(3));
              list.add(student);
                     
          }
      } catch (SQLException e){
          e.printStackTrace();
      }
      finally{
          try{
              stmt.close();
              rs.close();
          } catch (SQLException e){
              e.printStackTrace();
          }
      }
          
  }
  ~~~

---

### Spring JDBC

- dependencies
  - springcontext, mysql, spring jdbc
- source-folder(resources 만들고)
  - 우클릭 - Spring bean definition file - applicationContext

- 왜 JAVA JDBC에선 예외처리 했어?

  - sql rs.stmt.excuteQuery(sql) 가 안 하니까!
  - 그래서 이제, 그 통로에서 예외처리할거야
  - mybatis는 SqlSession에서 예외처리를 해줘서 편함
    - JDBC Templete을 bean으로 등록할거야

  ~~~xml
  <!-- resources폴더에서 !-->
  <bean class = "org.springframwork.jdbc.datasource.DriverManagerDataSource" id = "dataSoruce">
  	<property name = "driverClassName" value = "com.mysql.cj.jdbc.Driver"></property>
      <property name = "url" value = "jdbc:mysql://localhost:3306/ssafy_board?	    serverTimezone=UTC"></property>
      <property name = "username" value = "root"></property>
      <property name = "password" value = "root"></property>
  </bean>
  
  <bean class = "org.springframework.jdbc.core.JdbcTemplate">
      <property name = "dataSource" ref = "dataSoruce"></property>
  </bean>
  ~~~

  ~~~ java
  // 드라이버로딩 : spring
  // 연결 생성 : spring
  // DB연결정보(url, username, password)는 우리가 해야함  => DaoImpl
  // 구문객체생성 : spring
  // 실행 sql : 개발자.
  // 결과 매핑 : spring
  
  // 한 번만 만들면 되니까 굳이 implements 안하고 익명클래스!
  
  @Override
  public List<Student> selectAll(){
      String sql = "SELECT * FROM student";
      return jdbcTemplate.query(sql, rowMapper);
  }
  // 이런식으로 인터페이스를 만들면 어느 제네릭이든 만들어서 쓸 수 있구나!
  RowMapper<Student> mapper new RowMapper<Student>(){
      @Override
      public student mapRow(ResultSet rs, int rowNum) throws SQLException{
          Student student = new Student();
          student.setSnum(rs.getInt(1)); // 몇 번쨰 친구가 어떤 타입으로 어디에 들어가야..
          student.setSname(rs.getString(2));
          student.setSgrade(rs.getInt(3));
          list.add(student);
      }
  }
  ~~~



## Spring Transaction ( atomic : 더이상 쪼갤 수 없는)

- 트랜잭션이란 ? 쪼갤 수 없는 업무 처리의 최소 단위.

~~~ java
public interface StudentService throws Exception{
    List<Student> getStudentList();
    // 한 학급의 학생들을 한 번에 DB에 때려박는 기능 : 한 학급 자체를 쪼갤수없다고 생ㄱ가
    void registerClass(List<Student> list);
}
~~~

~~~java
@Service("StudentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    
    @Override
    public List<Student> getStudentList(){
        return studentDao.selectAll();
        
    }
    @Transactional
    @Override
    public void registerClass(List<Student> )throws Exception{
        for(Student s : list){
            studentDao.insertStudent(s);
        }
    }  
    //트랜잭션을 시작한다
    //try (커밋한다)
    //catch (Exception e) 롤백한다
    //finally트랜잭션을 종료한다
    
    // 모양새가 딱 AOP, 그래서 aop에서 동작할  transaction advice를 작성
}
~~~

#### in applicationContext.xml

1. transactionManager를 dataSource를 먹여서 생성해서 빈으로 등록.

2. aop에서 동작할 transaction advice를 작성 ( namespaces - tx 추가!)
3. adivce를 aop에 태운다 (namespaces - aop 추가!)

~~~ xml
<!-- resources폴더에서 !-->
<beans>
    <context:component-scan base-package = "com.ssafy.jdbc.model.dao"></context:component-scan>
    <context:component-scan base-package = "com.ssafy.jdbc.model.Service"></context:component-scan>
    <bean class = "org.springframwork.jdbc.datasource.DriverManagerDataSource" id = "dataSoruce">
        <property name = "driverClassName" value = "com.mysql.cj.jdbc.Driver"></property>
        <property name = "url" value = "jdbc:mysql://localhost:3306/ssafy_board?	    serverTimezone=UTC"></property>
        <property name = "username" value = "root"></property>
        <property name = "password" value = "root"></property>
    </bean>

    <bean class = "org.springframework.jdbc.core.JdbcTemplate">
        <property name = "dataSource" ref = "dataSoruce"></property>
    </bean>
    
    
    
    <!-- 1. transactionManager를 dataSource를 먹여서 생성해서 빈으로 등록. -->
    <bean class = "org.springframework.jdbc.datasource.DataSourceTransactionManager" id = "transactionManager">
        <property name = "dataSource" ref = "dataSource"></property>
    </bean> 
    <!-- 2. aop에서 동작할 transaction advice를 작성 -->
    <tx:adivce transaction-manager = "transactionManager" id = "txAdvice">
        <tx:attributes>
            <tx:method name = "*" rollback-for = "Exception"/> <!--Exception이 발생, 이걸로-->
        </tx:attributes>
    </tx:adivce>
    <!-- 3. adivce를 aop에 태운다 -->
    <aop:config>
        <aop:advisor advice-ref = "txAdvice"
                     pointcut = "excution(* com.ssafy.jdbc..*.register*(..))">

        </aop:advisor>
    </aop:config>
    <!-- 이거만 달고 그냥 하면 됍니다 -->
    <tx:annotation-driven transaction-manager="transactionManager">
    </tx:annotation-driven>
</beans>
~~~

현실

0. transaction에 대해 annotation-driven

---

## MyBatis

### 개념

- SQL 매핑 프레임워크
  - SQL문과 저장프로시저 등의 매핑을 지원하는 퍼시스턴스 프레임워크(persistence framework)
- JDBC로 처리하는 상당부분의 코드(커넥션, 예외처리 등) 파라미터 설정(??) 및 결과 처리(R.S)를 대신
- Map 인터페이스 그리고 자바 POJO를 설정 DB와 매핑하여 사용할 수 있다. XML과 Annotation 설정을 통해 사용할 수 있다.

cf) POJO : Plain Old Java Object :

- 오래된 방식의 자바 프로젝트
- 본래의 자바의 장점을 살리는 것(객체지향적인 원리 충실)
- 특정 환경에 종속되어 의존하는 자바 코드는 가독성이 떨어진다.

---

### 구성

- 환경설정파일
  - MyBatis 전반에 걸친 세팅
  - 모델 클래스 정보(Alias), DB접속정보, 매핑(매퍼) 정보
  - configuration.xml 에서 본다면
    - \<typeAliases>, \<environments>, \<mappers>
- Mapper
  - 사용할 SQL문 정의
  - namespaces로 어떤 DAO에 연관돼있는지 알려줘야함(인터페이스 - 자동매칭 )
- Mapped Statement
  - SqlSession 빌드 및 사용
  - SQL문 실행
  - Mapper Namespace와 연결된 인터페이스의 구현체, 여기서 SqlSessionFactory 나 SqlSession을 활용해서 직접 소통한다.
- Input/Output
  - SQL 실행 시 필요한 데이터
  - SQL 실행 결과

---

### 구성2

- SqlSessionFactory
  - 모든 마이바티스 애플리케이션은 SqlSessionFactory의 인스턴스를 사용한다. SqlSessionFactory는 Sqlsession을 만드는 공장
- SqlSession
  - 데이터베이스에 대해 SQL 명령어를 실행하기 위해 필요한 모든 메소드를 가지고 있다
  - 그래서 SqlSession 인스턴스를 통해 직접 SQL 구문을 실행할 수 있다.
- 예시

~~~java
is = Resources.getResoruceAsStream("dao1/configuration.xml");
sessionFactory = new SqlSessionFactoryBuilder().build(is);
// SqlSessionFactoryBuilder를 활용해 SqlSessionFactory 인스턴스를 생성한다.
~~~

---

### MyBatis 설정하기

- 설정파일 작성

  - xml형태의 설정파일 안에는 TransactionManager, Datasoruce등의 설정을 포함한다

- typeAliases

  - type : Model 클래스로 사용할 class의 full path(보통 dto, 내가 원하는 자료형을 만들어서 사용)
  - alias : MyBatis 내에서 사용할 model 클래스의 이름(이것만 쓰면 알아서 그 경로 가줘)

- mappers

  - SQL문이 작성된 매핑 파일의 위치 작성
    - Mapper가 xml 작성 된 경우와, Interface로 작성되었을 경우 설정 방법이 다름!
  - 보통 resources라는 소스 폴더 만들고, 그 안에 xml 형태로 작성한다

  cf) namespace?

  - 패기지를 포함한 전체 이름을 가진 구문을 구분하기 위함
  - **인터페이스 바인딩을 가능하게 함**

  

  

- Environments

  - Database 접속 정보, transaction 관리 방법등을 정의한다
    - transactionManager : Transaction 관리 방법 설정(JDBC : 수동, MANAGED : 자동)
    - dataSource : JDBC Connection 객체의 소스 설정(UNPOOLED : 매 요청마다 커넥션을 열고 닫음)

---

### Mapper 작성 

- 보통 mybatis.org에서 **매핑된 sql 구문 살펴보기** 로 들어가서 위에있는 태그들 복사붙여넣기 해서 사용

- Mapper는 xml이나 Annotation을 사용해서 정의할 수 있다.

  - \<select id = "인터페이스함수이름", parameterType = "들어오는 입력값", resultType = "나가는거">
  - insert, update, delete 사용 가능한 부분!

- cf)

  - #{id} => 마이바티스에게 PreparedStatement 파라미터를 만들도록 지시

  - JDBC를 사용할 때 PreparedStatement는 "?" 형태로 파라미터가 전달되는것과 같다.

  - JDBC 유사 예시

  - ~~~java
    String selectPerson = "SELECT * FROM PERSON WHERE ID = ?";
    PreparedStatement ps = conn.prepareStatement(selectPerson);
    ps.setInt(1,id);
    ~~~

---

#### ver1

- mapper.xml에 sql 구문 정보를 작성하고
- Dao에서 SqlSessionFacory를 소유하면서
- 각각의 필요한 기능에서 자신에 맞는 mapper 구문을 호출하도록 구현



- Dao Interface를 상속받은 구현체에서는 
  - 설정파일과 SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory 인스턴스를 생성한다
  - private SqlSessionFactory sessionFactory를 상단에 지정
  - 정의된 메서드를 실행 할 때 마다, sqlSessionFactory.openSession()을통해 session인스턴스 get
  - Mapper에 작성한 SQL을 매핑하여 실행 SQL을 자바코드와 별도로 분리하여 작성, 유지관리에 용이

---

#### ver2

- sql구문을 자신이 호출하고자 하는 인터페이스의 함수 위에 에노테이션을 작성
- dao에서 SqlSessionFactory를 소유하면서 
- Mapper객체(마바가 만들어주는 Dao구현체를) 얻어와 호출

~~~ java
// DAO 작성
//메또드 안
public int deleteMember(int num){
    SqlSession session = sessionFactory.openSession();
    MemberMapper mapper = session.getMapper(MemberMapper.class);
    try{
        return mapper.deleteMember(num);
    } finally{
        session.close
    }
 }
// SqlSession 객체를 이용하여 Mapper인터페이스의 인스턴스르 ㄹ생성한다.
// 인터페이스 인스턴스를 생성하기 때문에 메서드 호출이 용 이 
~~~

---

#### ver3 ( Xml Mapper + Mapper Interface)

- xml에 구문 정보를 작성하되, 짝궁 될 인터페이스의 풀패키지명을 namespace로
- 각가의 구문의 아이디를 짝꿍의 함수명으로 매칭
- dao에서 SqlSessionFactory를 소유하면서 
- Mapper객체(마바가 만들어주는 Dao구현체를) 얻어와 호출

MemberMapper.xml

~~~xml
<mapper namespace = "dao.MemberMapper"></mapper>

<select id = "selectAll" resultType = "Member">
    select * from saffy_member
</select>
~~~

MemberMapper.java

~~~ java
public List<Member> selectAll();
~~~



## Spring - MyBatis

- 스프링은 객체관리컨테이너!로써 객체관리전문가
- 데이터베이스와의 연결에 해당하는 객체 역시 스프링이 관리한다
- 아까는 마바설정에서 Database연결정보를 했지만, 이것은 스프링으로 이관된다.
- 위에 있는 DataSource에다가+타입알리아스+매퍼 정보만 있으면 SqlSessionFactory를 만들 수 있음

---

### MyBatis와 스프링 연동 

1. MyBatis와 스프링 프레임워크를 연동하기 위해서는 mybatis-spring 연동 라이브러리가 필요
   - mvn - mybatis-spring 다운로드

2. MyBatis 실행에 필요한 객체를 Spring Bean으로 등록하여 사용
   - dataSource, sqlSessionFactory 

3. DAO 작성

   - Mapper scanner를 사용하여 등록
   - basePackage에 설정된 패키지 하위의 모든 매퍼 인터페이스가 자동으로 bean으로 등록됨

   root-context.xml 추가

root-context.xml // jdbc 연결

~~~xml
<bean id = "dataSource"
      class = "org.springframework.jdbc.datasource.DriverManagerDataSoruce">
    <property name = "driverClassName" value = "${db.driver}"/>
    <property name = "url" value = "${db.url}"/>
    <property name = "username" value = "${db.username}"/>
    <property name = "password" value = "${db.password}"/>
</bean>
<!-- 여기서 추가 !-->
<bean id = "sqlSessionFactory"
      class = "org.mybatis.spring.SqlSessionFactoryBean">
	<property name = "dataSoruce" ref = "dataSoruce"/> <!-- 저 위에있는거 -->
    <property name = "mapperLocations" value = "classpath:dao/mapper/**/*.xml"/> 매퍼
    <property name = "typeAliasesPackage" value = "model"/>
</bean>
<!-- 추가-->
<bean id = "boardDao" class = "org.mybatis.spring.mapper.MapperFactoryBean">
    <property name = "mapperInterface" value = "dao.BoardDao"/>
    <property name = "SqlSessionFactory" ref = "sqlSessionFactory"/> <!--위에서만든거-->
</bean>
<!-- 추가-->
<bean id = "mapperScanner" class = "org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name = "basePackage" value = "dao"></property>
</bean>
~~~

- ​	사용되는거 : DriverManagerDataSource, SqlSesiionFactoryBean, MapperFactoryBean, MapperScannerConfigurer

---

- 연동방법1
  - 스프링에서 SqlSessionFactory를 빈으로 등록하고 기존 코드대로 Dao에 팩토리를 주입시켜 활용
- 연동방법 2
  - 스프링은 객체관리전문가이기 떄문에
  - 쓰레드안전한 SqlSession객체를 만들어 준다. 이놈을 주입받아서 사용해도 좋다.
- 연동방법 3
  - 매퍼 주입

