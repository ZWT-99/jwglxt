/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.departs.entity.Departs;
import com.jeesite.modules.departs.dao.DepartsDao;

/**
 * departsService
 * @author sdy
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class DepartsService extends CrudService<DepartsDao, Departs> {
	
	/**
	 * 获取单条数据
	 * @param departs
	 * @return
	 */
	@Override
	public Departs get(Departs departs) {
		return super.get(departs);
	}
	
	/**
	 * 查询分页数据
	 * @param departs 查询条件
	 * @param departs.page 分页对象
	 * @return
	 */
	@Override
	public Page<Departs> findPage(Departs departs) {
		return super.findPage(departs);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param departs
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Departs departs) {
		super.save(departs);
	}
	
	/**
	 * 更新状态
	 * @param departs
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Departs departs) {
		super.updateStatus(departs);
	}
	
	/**
	 * 删除数据
	 * @param departs
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Departs departs) {
		super.delete(departs);
	}
	
}