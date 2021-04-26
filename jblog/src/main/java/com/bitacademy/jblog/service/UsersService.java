package com.bitacademy.jblog.service;

import com.bitacademy.jblog.vo.UserVo;

public interface UsersService {
	public UserVo login(String id,String pw);	//로그인
	public boolean idCheck(String id);				//id중복체크
	public boolean userInsert(UserVo uvo);			//회원가입
	public Long selectUserNo(String id);
	public String selectId(Long userNo);
}
