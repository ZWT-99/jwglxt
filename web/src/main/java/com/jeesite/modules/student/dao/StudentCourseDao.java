/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.student.entity.StudentCourse;

/**
 * studentDAO接口
 * @author sdy
 * @version 2021-01-07
 */
@MyBatisDao
public interface StudentCourseDao extends CrudDao<StudentCourse> {
	
}