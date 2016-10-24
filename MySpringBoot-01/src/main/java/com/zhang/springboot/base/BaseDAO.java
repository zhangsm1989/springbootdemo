package com.zhang.springboot.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>Description: [公共DAO父级接口]</p>
 * @version 1.0
 * Copyright (c) 2016 北京柯莱特科技有限公司 交付部
 */
public interface BaseDAO<T> {

	/**
	 * <p>Discription:[新增]</p>
	 * @param t 新增的实体对象
	 */
	void add(T t);

	/**
	 * <p>Discription:[根据ID查询]</p>
	 * @param id 主键编号
	 * @return
	 */
	T queryById(Object id);

	/**
	 * <p>Discription:[修改]</p>
	 * @param t 需要修改的实体Bean
	 */
	Integer update(T t);

	/**
	 * <p>Discription:[根据查询条件修改]</p>
	 * @param t 需要修改的实体Bean
	 */
	Integer updateBySelect(T t);

	/**
	 * <p>Discription:[根据ID删除数据]</p>
	 * @param id 主键ID
	 * @return
	 */
	Integer delete(Object id);

	/**
	 * <p>Discription:[根据条件查询总数]</p>
	 * @param t Bean对象查询条件
	 * @return 总数
	 */
	Long queryCount(@Param("entity") T t, @Param("paramMap") Map<String, Object> paramMap);
	
	/**
	 * <p>Discription:[根据条件进行分页查询]</p>
	 * @param t Bean对象查询条件
	 * @param page 分页对象
	 * @param paramMap Bean实体外的查询参数
	 * @return Bean实体list集合
	 */
	List<T> queryList(@Param("entity") T t, @SuppressWarnings("rawtypes") @Param("page") Pager page, @Param("paramMap") Map<String, Object> paramMap);

}
