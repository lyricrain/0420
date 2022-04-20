package org.kosta.myboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;
import org.kosta.myboard.model.PostVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인 여부를 체크해서 로그인 상태가 아니면 홈으로 리다이렉트시킨다 
		/*
		 * HttpSession session=request.getSession(false);
		 * if(session==null||session.getAttribute("mvo")==null) return
		 * "redirect:ListController.do";
		 */
		
		String no=request.getParameter("no");
		@SuppressWarnings("unchecked")
		ArrayList<String> myboardNo=(ArrayList<String>)request.getSession(false).getAttribute("myboardNo");
		if(myboardNo.contains(no)==false) { //로그인 후 한번도 읽지 않은 게시글이면 
			//조회수 증가 
		    BoardDAO.getInstance().updateHits(no);
		    myboardNo.add(no);
		}		
		//상세 게시물 조회 
		PostVO pvo=BoardDAO.getInstance().getPostingByNo(no);
		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "board/post-detail.jsp");
		return "layout.jsp";
	}

}





