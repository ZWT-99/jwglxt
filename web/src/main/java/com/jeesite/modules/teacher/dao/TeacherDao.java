/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.teacher.entity.Teacher;

/**
 * teacherDAO接口
 * @author sdy
 * @version 2021-01-06
 */
@MyBatisDao
public interface TeacherDao extends CrudDao<Teacher> {
	
}