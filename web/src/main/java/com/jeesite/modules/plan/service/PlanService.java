/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.plan.entity.Plan;
import com.jeesite.modules.plan.dao.PlanDao;

/**
 * planService
 * @author gjc
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class PlanService extends CrudService<PlanDao, Plan> {
	
	/**
	 * 获取单条数据
	 * @param plan
	 * @return
	 */
	@Override
	public Plan get(Plan plan) {
		return super.get(plan);
	}
	
	/**
	 * 查询分页数据
	 * @param plan 查询条件
	 * @param plan.page 分页对象
	 * @return
	 */
	@Override
	public Page<Plan> findPage(Plan plan) {
		return super.findPage(plan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param plan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Plan plan) {
		super.save(plan);
	}
	
	/**
	 * 更新状态
	 * @param plan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Plan plan) {
		super.updateStatus(plan);
	}
	
	/**
	 * 删除数据
	 * @param plan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Plan plan) {
		super.delete(plan);
	}
	
}