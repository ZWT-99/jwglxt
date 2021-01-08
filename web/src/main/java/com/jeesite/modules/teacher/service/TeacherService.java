/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.teacher.entity.Teacher;
import com.jeesite.modules.teacher.dao.TeacherDao;

/**
 * teacherService
 * @author sdy
 * @version 2021-01-08
 */
@Service
@Transactional(readOnly=true)
public class TeacherService extends CrudService<TeacherDao, Teacher> {
	
	/**
	 * 获取单条数据
	 * @param teacher
	 * @return
	 */
	@Override
	public Teacher get(Teacher teacher) {
		return super.get(teacher);
	}
	
	/**
	 * 查询分页数据
	 * @param teacher 查询条件
	 * @param teacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<Teacher> findPage(Teacher teacher) {
		return super.findPage(teacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Teacher teacher) {
		super.save(teacher);
	}
	
	/**
	 * 更新状态
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Teacher teacher) {
		super.updateStatus(teacher);
	}
	
	/**
	 * 删除数据
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Teacher teacher) {
		super.delete(teacher);
	}
	
}