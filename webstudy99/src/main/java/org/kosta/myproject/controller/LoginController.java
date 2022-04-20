package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		MemberVO vo=MemberDAO.getInstance().login(id, password);
		String viewName=null;
		if(vo==null) {// 로그인 실패 
			viewName="member/login-fail.jsp";
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("mvo", vo);
			viewName="redirect:ListController.do";
		}
		return viewName;
	}
}
