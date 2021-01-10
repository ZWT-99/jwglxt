/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teaching.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.TreeService;
import com.jeesite.modules.teaching.entity.TeachingPlan;
import com.jeesite.modules.teaching.dao.TeachingPlanDao;

/**
 * 行政区划Service
 * @author sdy
 * @version 2021-01-10
 */
@Service
@Transactional(readOnly=true)
public class TeachingPlanService extends TreeService<TeachingPlanDao, TeachingPlan> {
	
	/**
	 * 获取单条数据
	 * @param teachingPlan
	 * @return
	 */
	@Override
	public TeachingPlan get(TeachingPlan teachingPlan) {
		return super.get(teachingPlan);
	}
	
	/**
	 * 查询列表数据
	 * @param teachingPlan
	 * @return
	 */
	@Override
	public List<TeachingPlan> findList(TeachingPlan teachingPlan) {
		return super.findList(teachingPlan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param teachingPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TeachingPlan teachingPlan) {
		super.save(teachingPlan);
	}
	
	/**
	 * 更新状态
	 * @param teachingPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TeachingPlan teachingPlan) {
		super.updateStatus(teachingPlan);
	}
	
	/**
	 * 删除数据
	 * @param teachingPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TeachingPlan teachingPlan) {
		super.delete(teachingPlan);
	}
	
}