package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BoardDAO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", BoardDAO.getInstance().findPostList());
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
