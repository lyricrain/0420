package org.kosta.myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;

public class UpdatePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 체크
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("mvo") == null) return "redirect:ListController.do";
		 */
		// 요청방식 post 체크
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("게시글 삭제는 post 방식만 허용됩니다");
		
		request.setAttribute("pvo", BoardDAO.getInstance().getPostingByNo(request.getParameter("no")));
		request.setAttribute("url", "board/update.jsp");
		return "layout.jsp";
	}

}
