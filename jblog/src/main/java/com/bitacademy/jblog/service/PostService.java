package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.PostVo;

public interface PostService {
	public List<PostVo> postList(Long cateNo);
	public PostVo selectPost(Long postNo);
	public boolean createPost(PostVo vo);
	public PostVo selectCount(Long cateNo,Long userNo);
}
