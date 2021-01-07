/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.course.entity.Course;
import com.jeesite.modules.course.dao.CourseDao;

/**
 * courseService
 * @author sdy
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class CourseService extends CrudService<CourseDao, Course> {
	
	/**
	 * 获取单条数据
	 * @param course
	 * @return
	 */
	@Override
	public Course get(Course course) {
		return super.get(course);
	}
	
	/**
	 * 查询分页数据
	 * @param course 查询条件
	 * @param course.page 分页对象
	 * @return
	 */
	@Override
	public Page<Course> findPage(Course course) {
		return super.findPage(course);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param course
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Course course) {
		super.save(course);
	}
	
	/**
	 * 更新状态
	 * @param course
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Course course) {
		super.updateStatus(course);
	}
	
	/**
	 * 删除数据
	 * @param course
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Course course) {
		super.delete(course);
	}
	
}