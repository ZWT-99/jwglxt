/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.student.entity.Student;
import com.jeesite.modules.student.dao.StudentDao;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.student.entity.StudentCourse;
import com.jeesite.modules.student.dao.StudentCourseDao;

/**
 * studentService
 * @author sdy
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class StudentService extends CrudService<StudentDao, Student> {
	
	@Autowired
	private StudentCourseDao studentCourseDao;
	
	/**
	 * 获取单条数据
	 * @param student
	 * @return
	 */
	@Override
	public Student get(Student student) {
		Student entity = super.get(student);
		if (entity != null){
			StudentCourse studentCourse = new StudentCourse(entity);
			studentCourse.setStatus(StudentCourse.STATUS_NORMAL);
			entity.setStudentCourseList(studentCourseDao.findList(studentCourse));
		}
		return entity;
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
		// 保存上传附件
		FileUploadUtils.saveFileUpload(student.getId(), "student_file");
		// 保存 Student子表
		for (StudentCourse studentCourse : student.getStudentCourseList()){
			if (!StudentCourse.STATUS_DELETE.equals(studentCourse.getStatus())){
				studentCourse.setSnoId(student);
				if (studentCourse.getIsNewRecord()){
					studentCourseDao.insert(studentCourse);
				}else{
					studentCourseDao.update(studentCourse);
				}
			}else{
				studentCourseDao.delete(studentCourse);
			}
		}
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
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setSnoId(student);
		studentCourseDao.deleteByEntity(studentCourse);
	}
	
}