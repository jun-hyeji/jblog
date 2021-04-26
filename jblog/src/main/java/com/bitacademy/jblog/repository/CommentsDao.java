package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.CommentsVo;

public interface CommentsDao {

	public List<CommentsVo> cmtList(Long postNo); 
	public int cmtInsert(CommentsVo vo);
	public int cmtDelete(Long cmtNo);
}
