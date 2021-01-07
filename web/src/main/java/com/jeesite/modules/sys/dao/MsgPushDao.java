/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sys.entity.MsgPush;

/**
 * 消息推送表DAO接口
 * @author gjc
 * @version 2021-01-07
 */
@MyBatisDao
public interface MsgPushDao extends CrudDao<MsgPush> {
	
}