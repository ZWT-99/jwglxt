/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.departs.entity.Departs;

/**
 * departsDAO接口
 * @author sdy
 * @version 2021-01-07
 */
@MyBatisDao
public interface DepartsDao extends CrudDao<Departs> {
	
}