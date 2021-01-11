/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.plan.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.plan.entity.Plan;

/**
 * planDAO接口
 * @author gjc
 * @version 2021-01-11
 */
@MyBatisDao
public interface PlanDao extends CrudDao<Plan> {
	
}