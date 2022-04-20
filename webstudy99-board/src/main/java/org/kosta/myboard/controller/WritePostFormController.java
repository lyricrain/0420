package org.kosta.myboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WritePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크 
		/*
		 * HttpSession session=request.getSession(false);
		 * if(session==null||session.getAttribute("mvo")==null) return
		 * "redirect:ListController.do";
		 */
		
		request.setAttribute("url", "board/write.jsp");
		return "layout.jsp";
	}

}
