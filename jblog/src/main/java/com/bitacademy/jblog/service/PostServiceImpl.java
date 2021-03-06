package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostDao;
import com.bitacademy.jblog.vo.PostVo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDao;

	@Override
	public List<PostVo> postList(Long cateNo) {
		List<PostVo> list = postDao.postList(cateNo);
		return list;
	}

	@Override
	public PostVo selectPost(Long postNo) {
		PostVo vo = postDao.selectPost(postNo);
		return vo;
	}

	@Override
	public boolean createPost(PostVo vo) {
		int result = postDao.createPost(vo);
		return result==1;
	}

	@Override
	public PostVo selectCount(Long cateNo,Long userNo) {
		PostVo vo = postDao.selectCount(cateNo, userNo);
		return vo;
	}

}
