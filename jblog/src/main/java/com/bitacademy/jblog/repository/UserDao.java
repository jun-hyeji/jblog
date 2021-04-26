package com.bitacademy.jblog.repository;

import com.bitacademy.jblog.vo.UserVo;

public interface UserDao {
	public UserVo login(String id,String pw);	
	public int idCheck(String id);				
	public int insert(UserVo vo);
	public Long selectUserNo(String id);
	public String selectId(Long userNo);
	
}
