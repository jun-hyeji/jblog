package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> categoryAndCntList(Long userNo);
	public List<CategoryVo> categoryList(Long userNo);		
	public CategoryVo selectCategory(Long cateNo);			
	public boolean createCategory(CategoryVo vo);
	public boolean categoryDelete(Long cateNo);
}
