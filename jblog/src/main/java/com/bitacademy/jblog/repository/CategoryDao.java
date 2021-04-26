package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.CategoryVo;

public interface CategoryDao {

	public List<CategoryVo> categoryList(Long userNo);
	public List<CategoryVo> categoryAndCntList(Long userNo);
	public CategoryVo selectCategory(Long cateNo);
	public int categoryInsert(CategoryVo vo);
	public int categoryDelete(Long cateNo);
}
