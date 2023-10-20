package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.dto.LoginDTO;
import com.project.mapper.LoginMapper;

@Service
public class LoginService {
	private static LoginMapper mapper;

	public LoginService(LoginMapper mapper) {
		this.mapper = mapper;
	}

	public LoginDTO login(String userId, String passwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("passwd", passwd);

		return mapper.login(map);
	}
	public int insertUser(LoginDTO dto) {
		return mapper.insertUser(dto);
	}
	public int UserCheckId(String id, String type) {
		if (type.equals("user")) {
			return mapper.UserCheckId(id);

		}
		return 0;
	}


	public boolean checkPasswd(String nowPass) {
		String dto = mapper.checkPasswd(nowPass);
			return dto != null;
		}
	//아이디 찾기
	public String findId(String userId) {
		return mapper.findId(userId);
	}
	//비밀번호 변경
	public int updatePasswd(String newPass) {
		return mapper.updatePasswd(newPass);
	}
	//비밀번호 변경시 아이디 확인
	public boolean checkId(String insertId) {
		String dto = mapper.searchId(insertId);
		return dto != null;
	}
	public boolean checkpartno(String insertpartno) {
		String dto = mapper.searchpartno(insertpartno);
		return dto != null;
	}
}
