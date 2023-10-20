package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dto.LoginDTO;
import com.project.service.LoginService;

@Controller
public class LoginController {
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	// web 로그인페이지
	@RequestMapping("/")
	public String main() {

		return "mainpage/login";
	}

	// web 로그인 적용페이지
	@RequestMapping("/login")
	public String login(String userId, String passwd, HttpSession session, HttpServletResponse response)
			throws IOException {
		LoginDTO dto = loginService.login(userId, passwd);
		if (dto != null) {
			session.setAttribute("user", dto);
			System.out.println(session.getMaxInactiveInterval());
			return "redirect:/mainpage"; // 메인 페이지로 이동
		} else if (dto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script language='javascript'>");
			out.println("alert('아이디 또는 비밀번호가 틀렸습니다.')");
			out.println("</script>");

			out.flush();
			return "mainpage/login";
		} else {

			return "mainpage/login";

		}
	}

	// web 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션을 무효화하여 로그아웃 처리
		return "redirect:/"; // 로그아웃 후 메인페이지로 리다이렉트
	}

	// web 회원가입
	@RequestMapping("/join")
	public String join() {
		return "mainpage/join";
	}

	// web 회원가입 완료시 넘어가는 페이지
	@RequestMapping("/join/action")
	public String join(String userId) {
		String result = loginService.findId(userId);
		return "mainpage/join_Complete";
	}

	// web 회원가입 성공
	@RequestMapping("/join_complete")
	public String Join_Complete() {
		return "redirect:/";
	}

	// 아이디 중복 검사
	@RequestMapping("join/checkid")
	@ResponseBody
	public int checkid(@RequestParam("id") String id, @RequestParam("type") String type, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("type", type);
		return loginService.UserCheckId(id, type);
	}

	// 아이디 찾기
	@RequestMapping("/findId")
	public String findId() {
		return "mainpage/findId";
	}
	//아이디 찾기 결과
	@RequestMapping("/findId_result")
	public String findId_result() {
		return "mainpage/findId_result";
	}
	//비밀번호 찾기
	@RequestMapping("/findpw")
	public String findpw() {
		return "mainpage/findpw";
	}
	//아이디 맞는지 확인
	@RequestMapping("/comfirm/id")
	@ResponseBody
	public int checkId(@RequestParam("insertId") String insertId) throws Exception{
		boolean userIdValid = loginService.checkId(insertId);
		System.out.println(userIdValid);
		if(!userIdValid) {
			return 0; // 현재 아이디가 일치하지 않음
		}
		return 1; //아이디 조회 성공
		 
	}
	@RequestMapping("/comfirm/partno")
	@ResponseBody
	public int checkpartno(@RequestParam("insertpartno") String insertpartno) throws Exception{
		boolean userPartnoValid = loginService.checkpartno(insertpartno);
		System.out.println(userPartnoValid);
		if(!userPartnoValid) {
			return 0; // 현재 부서 번호가 일치하지 않음
		}
		return 1; //부서번호 조회 성공
	}
}
