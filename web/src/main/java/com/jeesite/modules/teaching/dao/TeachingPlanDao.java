/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teaching.dao;

import com.jeesite.common.dao.TreeDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.teaching.entity.TeachingPlan;

/**
 * 行政区划DAO接口
 * @author sdy
 * @version 2021-01-10
 */
@MyBatisDao
public interface TeachingPlanDao extends TreeDao<TeachingPlan> {
	
}