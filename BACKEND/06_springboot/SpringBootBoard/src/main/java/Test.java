import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hamakim94.board.model.dao.BoardDao;
import com.hamakim94.board.model.dto.Board;
import com.hamakim94.board.model.dto.User;
import com.hamakim94.board.model.service.UserService;

public class Test {
	public static void main(String[] args) {
//		System.out.println("실행된다능");
		
		ApplicationContext context
		= new GenericXmlApplicationContext("root-context.xml");
		
//		BoardDao boardDao = context.getBean("boardDao", BoardDao.class);
//		for(Board b : boardDao.selectList()) {
//			System.out.println(b);
//		}
		
		UserService userService = context.getBean("userService", UserService.class);
		User user = new User("iccack", "qp102pw98", "HongSG");
		
//		try {
//			userService.join(user, "두 번쨰 가입");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("예외발생 ㅋ");
//			System.out.println(e.getMessage());
//			// e.printStackTrace();
//		}
		
		try {
			System.out.println(userService.login("iccack", "qp102pw98"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
