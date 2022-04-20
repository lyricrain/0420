package org.kosta.myboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;
import org.kosta.myboard.model.PagingBean;
import org.kosta.myboard.model.PostVO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalPostCount=BoardDAO.getInstance().getTotalPostCount();
		String pageNo=request.getParameter("pageNo");
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(totalPostCount);//현재 페이지가 1 page로 할당되어 있음 
		}else {
			//client에서 보낸 page 번호로 할당한다 
			pagingBean=new PagingBean(totalPostCount,Integer.parseInt(pageNo));
		}
		ArrayList<PostVO> list=BoardDAO.getInstance().getPostingList(pagingBean);
		//게시물 리스트 정보 
		request.setAttribute("list", list);
		//페이징 정보 
		request.setAttribute("pagingBean", pagingBean);
		//template layout 페이지를 이용해 리스트 화면을 제공 
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}
}
