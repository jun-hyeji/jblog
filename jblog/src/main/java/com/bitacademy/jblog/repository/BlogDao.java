package com.bitacademy.jblog.repository;

public interface BlogDao {
	
	public BlogVo selectBlog(String id);
	public int blogInsert(BlogVo vo);
	public int blogUpdate(BlogVo vo);

}