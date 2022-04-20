package org.kosta.myboard.controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myboard.model.MemberDAO;
import org.kosta.myboard.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//post 요청방식만 로그인 처리한다 
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("로그인은 post방식만 가능합니다!");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		MemberVO memberVO=MemberDAO.getInstance().login(id, password);
		if(memberVO==null) {
			return "redirect:member/login-fail.jsp";
		}else {
			HttpSession session=request.getSession();
			//로그인 인증 정보 할당 
			session.setAttribute("mvo", memberVO);
			
			// 조회수 재증가 방지를 위해  
			// 로그인한 회원이 게시글을 읽었을 때 게시물 번호를 저장하는 리스트를 생성해서 
			// 세션에 저장한다 
			// 한번 읽은 게시글에 대해서는 조회수가 재증가 되는 것을 막도록 하기 위해서임 
			session.setAttribute("myboardNo", new ArrayList<String>());
			
			
			//로그인 완료 후 게시판 리스트 화면( 홈화면) 을 제공하기 위해 ListController로 redirect
			return "redirect:ListController.do";
		}		
	}
}









