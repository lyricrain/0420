package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance=new BoardDAO();
	private DataSource dataSource;
	private BoardDAO() {
		this.dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); // 컨넥션을 컨넥션풀에 반납한다 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}	
	public ArrayList<PostVO> findPostList() throws SQLException {
		ArrayList<PostVO> list=new ArrayList<PostVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT b.no,b.title,m.name,TO_CHAR(time_posted,'YYYY.MM.DD') as time_posted,b.hits ");
			sql.append("FROM member m ");
			sql.append("INNER JOIN board b ON m.id=b.id ");
			sql.append("ORDER BY b.no DESC ");
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO memberVO=new MemberVO();
				memberVO.setName(rs.getString("name"));
				PostVO postVO=new PostVO();
				postVO.setNo(rs.getInt("no"));
				postVO.setTitle(rs.getString("title"));
				postVO.setTimePosted(rs.getString("time_posted"));
				postVO.setHits(rs.getInt("hits"));
				postVO.setMemberVO(memberVO);
				list.add(postVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}



















