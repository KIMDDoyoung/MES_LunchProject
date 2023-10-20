package com.project.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.LoginDTO;

@Mapper
public interface LoginMapper {
	LoginDTO login(Map<String , Object> map);

	int insertUser(LoginDTO dto);
	
	int UserCheckId(String id);
		
	String checkPasswd(String nowPass);
	
	int updatePasswd(String newPass);
	
	String searchId(String insertId);
	
	LoginDTO getUserByUserId(String userId);

	String findId(String userId);

	String searchpartno(String insertpartno);
}
