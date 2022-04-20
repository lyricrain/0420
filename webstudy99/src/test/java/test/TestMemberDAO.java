package test;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class TestMemberDAO {
	public static void main(String[] args) {
		try {
		MemberDAO dao=MemberDAO.getInstance();
		MemberVO vo=dao.login("java","a2");
		System.out.println(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
