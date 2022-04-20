package org.kosta.myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;
import org.kosta.myboard.model.MemberVO;
import org.kosta.myboard.model.PostVO;

public class WritePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 체크
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("mvo") == null) return "redirect:ListController.do";
		 */
		// 요청방식 post 체크 
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("게시글 등록은 post 방식만 허용됩니다");
	
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		PostVO postVO=new PostVO();
		postVO.setTitle(title);
		postVO.setContent(content);
		postVO.setMemberVO((MemberVO)request.getSession(false).getAttribute("mvo"));
		
		BoardDAO.getInstance().posting(postVO);
		
		return "redirect:ListController.do";
	}
}









