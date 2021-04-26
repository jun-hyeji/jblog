package com.bitacademy.jblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.UserVo;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	@Override
	public int insert(UserVo vo) {
		int result = sqlSession.insert("user.insert2", vo);
		BlogVo bvo = new BlogVo();
		CategoryVo cvo = new CategoryVo();
		bvo.setUserNo(vo.getUserNo());
		bvo.setBlogTitle(vo.getUserName()+"의 블로그 입니다.");
		cvo.setUserNo(vo.getUserNo());
		cvo.setCateName("미분류");
		cvo.setDescription("처음으로 생성되는 카테고리입니다.");
		sqlSession.insert("blog.insert", bvo);
		sqlSession.insert("category.insert", cvo);
		return result;
	}

	@Override
	public UserVo login(String id, String pw) {
		Map<String,String> userMap = new HashMap<>();
		userMap.put("id",id);
		userMap.put("password", pw);
		UserVo vo = sqlSession.selectOne("user.login", userMap);
		return vo;
	}

	@Override
	public int idCheck(String id) {
		int result = sqlSession.selectOne("user.idCheck", id);
		return result;
	}

	
	@Override
	public Long selectUserNo(String id) { 
		Long userNo = sqlSession.selectOne("user.selectUserNo", id); 
		return userNo; 
	}

	@Override
	public String selectId(Long userNo) {
		String id = sqlSession.selectOne("user.selectId", userNo);
		return id;
	}

	@Override
	public com.bitacademy.jblog.repository.UserVo login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(com.bitacademy.jblog.repository.UserVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
