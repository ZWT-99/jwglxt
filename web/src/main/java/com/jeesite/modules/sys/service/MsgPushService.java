/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sys.entity.MsgPush;
import com.jeesite.modules.sys.dao.MsgPushDao;

/**
 * 消息推送表Service
 * @author gjc
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class MsgPushService extends CrudService<MsgPushDao, MsgPush> {
	
	/**
	 * 获取单条数据
	 * @param msgPush
	 * @return
	 */
	@Override
	public MsgPush get(MsgPush msgPush) {
		return super.get(msgPush);
	}
	
	/**
	 * 查询分页数据
	 * @param msgPush 查询条件
	 * @param msgPush.page 分页对象
	 * @return
	 */
	@Override
	public Page<MsgPush> findPage(MsgPush msgPush) {
		return super.findPage(msgPush);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param msgPush
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MsgPush msgPush) {
		super.save(msgPush);
	}
	
	/**
	 * 更新状态
	 * @param msgPush
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MsgPush msgPush) {
		super.updateStatus(msgPush);
	}
	
	/**
	 * 删除数据
	 * @param msgPush
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MsgPush msgPush) {
		super.delete(msgPush);
	}
	
}