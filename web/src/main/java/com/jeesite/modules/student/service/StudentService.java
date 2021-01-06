/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.student.entity.Student;
import com.jeesite.modules.student.dao.StudentDao;

/**
 * studentService
 * @author sdy
 * @version 2021-01-06
 */
@Service
@Transactional(readOnly=true)
public class StudentService extends CrudService<StudentDao, Student> {
	
	/**
	 * 获取单条数据
	 * @param student
	 * @return
	 */
	@Override
	public Student get(Student student) {
		return super.get(student);
	}
	
	/**
	 * 查询分页数据
	 * @param student 查询条件
	 * @param student.page 分页对象
	 * @return
	 */
	@Override
	public Page<Student> findPage(Student student) {
		return super.findPage(student);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param student
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Student student) {
		super.save(student);
	}
	
	/**
	 * 更新状态
	 * @param student
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Student student) {
		super.updateStatus(student);
	}
	
	/**
	 * 删除数据
	 * @param student
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Student student) {
		super.delete(student);
	}
	
}