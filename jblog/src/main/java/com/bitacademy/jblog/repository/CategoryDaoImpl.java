package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitacademy.jblog.vo.CategoryVo;

public class CategoryDaoImpl implements CategoryDao {


	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<CategoryVo> categoryList(Long userNo) {
		List<CategoryVo> list = sqlSession.selectList("category.categoryList", userNo);
		return list;
	}

	@Override
	public CategoryVo selectCategory(Long cateNo) {
		
		return null;
	}

	@Override
	public int categoryInsert(CategoryVo vo) {
		int result = sqlSession.insert("category.insert", vo);
		return result;
	}

	@Override
	public int categoryDelete(Long cateNo) {
		int result = sqlSession.delete("category.delete", cateNo);
		return result;
	}

	@Override
	public List<CategoryVo> categoryAndCntList(Long userNo) {
		List<CategoryVo> list = sqlSession.selectList("category.categoryAndCntList", userNo);
		return list;
	}
}
