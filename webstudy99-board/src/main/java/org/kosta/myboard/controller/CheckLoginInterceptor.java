package org.kosta.myboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor {
	private static CheckLoginInterceptor instance=new CheckLoginInterceptor();
	/**
	 *  permitAllList : 비로그인 상태에서 접근 가능한 컨트롤러 리스트 
	 *  				 이 리스트에 저장된 컨트롤러는 인증체크를 하지 않는다 
	 */
	private ArrayList<String> permitAllList;
	private CheckLoginInterceptor() {
		this.permitAllList=new ArrayList<String>();
		permitAllList.add("ListController");
		permitAllList.add("LoginController");
	}
	public static CheckLoginInterceptor getInstance() {
		return instance;
	}
	//로그인이 필요한 서비스임에도 비로그인 상태일때는 false, 문제없이 기존 컨트롤러 수행하면 true 
	public boolean checkLoginIntercept(HttpServletRequest request,String command) {
		boolean result=true;
		HttpSession session=request.getSession(false);
		// 인증이 필요한 컨트롤러이고 세션이 null 또는 세션 안의 mvo가 null 이면 
		if(permitAllList.contains(command)==false&&(session==null || session.getAttribute("mvo")==null)) {
			System.out.println("***"+command+" 인증이 필요한 서비스이므로 로그인해야함***");
			result=false;
		}		
		return result;
	}
}
