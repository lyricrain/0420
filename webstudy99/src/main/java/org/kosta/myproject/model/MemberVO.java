package org.kosta.myproject.model;

import java.io.Serializable;
/**
 *  현 시스템의 인증정보로 세션에 저장되는 회원객체 
 *  WAS 중단시 파일에 직렬화되어 백업되고 WAS 재개시 역직렬화되어 세션과 인증정보가 복원되므로
 *  객체 직렬화가 되어 위해서는 Serializable 을 구현해야 한다 
 * @author KOSTA
 *
 */
public class MemberVO implements Serializable{

	private static final long serialVersionUID = -3972768952288329070L;
	private String id;
	private String password;
	private String name;	
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
}
