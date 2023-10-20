package com.project.dto;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class LoginDTO {
	private String userId;
	private String passwd;
	private String partno;
	private String name;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getName() {
		return name;
	}

	public String getPartno() {
		return partno;
	}

	public void setPartno(String partno) {
		this.partno = partno;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public LoginDTO(String userId, String passwd, String partno, String name) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.partno = partno;
		this.name = name;
	}


	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", passwd=" + passwd + ", partno=" + partno + ", name=" + name + "]";
	}

	

}
