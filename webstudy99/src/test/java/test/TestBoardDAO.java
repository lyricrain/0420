package test;

import java.util.ArrayList;

import org.kosta.myproject.model.BoardDAO;
import org.kosta.myproject.model.PostVO;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao=BoardDAO.getInstance();
		try {
			// 게시물 리스트 조회 
			ArrayList<PostVO> list=dao.findPostList();
			for(PostVO vo:list)
				System.out.println(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}









