package com.hamakim94.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hamakim94.board.model.dto.User;
import com.hamakim94.board.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String loginForm() {
		return "user/login"; // "/"가 없으니까 viewResolver가 가져가서 JSP페이지 보여줌
	}
	
	@PostMapping("login") // post방식으로 보낼때 변수 이름 같아야 알아서 스프링이 넣어줌, 확인 필수!
	public String login(HttpSession session, String id, String pw) throws Exception {
		User user = userService.login(id, pw); // 이러면 로그인된 유저를 반환함.그리고 여기서 오류나면 userid ,pw exception 뜸!
		if(user != null) // 만약 제대로 반환 됐으면, username이라는 이름으로 user 객체를 담아.
			session.setAttribute("username",user.getUsername() );
		System.out.println(user.toString());
		return user!= null?"redirect:/":"redirect:/user/login"; // 보내던가 말던가~
	}
	
	@GetMapping("logout") // a tag로, header.jsp에서 ${root}/user/logout으로 보내기 때문!
	public String logout(HttpSession session) {
		session.invalidate(); // 지워
		return "redirect:/"; // 홈화면으로.
	}
	
	@GetMapping("join") // 회원 가입 클릭 <a href = ${root}/user/join>
	public String joinForm() {
		return "user/join";  // "/" 없으니까 viewResolver에의해 jsp로! 
	}
	
	@PostMapping("join")
	public String join(User user, String msg) { // 여기선 User라고 입벌리고 잇으니 변수명 같으면 알아서 넣어줘(by setter)
		try {
			userService.join(user, msg); // 해보고 에러나면 catch로.
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return "redirect:/user/join"; // 유저서블릿으로 다시 돌아와서 join method 실행해서 join.jsp로 감
		}
		return "redirect:/user/login"; // 회원가입 완료되면 로그인 창으로 가짐
	}
}
