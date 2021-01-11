/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.plan.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.plan.entity.Plan;
import com.jeesite.modules.plan.service.PlanService;

/**
 * planController
 * @author gjc
 * @version 2021-01-11
 */
@Controller
@RequestMapping(value = "${adminPath}/plan/plan")
public class PlanController extends BaseController {

	@Autowired
	private PlanService planService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Plan get(String planid, String 学期, String 年, String 课程编码, boolean isNewRecord) {
		Plan plan = new Plan();
		plan.setPlanid(planid);
		plan.set学期(学期);
		plan.set年(年);
		plan.set课程编码(课程编码);
		plan.setIsNewRecord(isNewRecord);
		return planService.getAndValid(plan);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("plan:plan:view")
	@RequestMapping(value = {"list", ""})
	public String list(Plan plan, Model model) {
		model.addAttribute("plan", plan);
		return "modules/plan/planList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("plan:plan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Plan> listData(Plan plan, HttpServletRequest request, HttpServletResponse response) {
		plan.setPage(new Page<>(request, response));
		Page<Plan> page = planService.findPage(plan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("plan:plan:view")
	@RequestMapping(value = "form")
	public String form(Plan plan, Model model) {
		model.addAttribute("plan", plan);
		return "modules/plan/planForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("plan:plan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Plan plan) {
		planService.save(plan);
		return renderResult(Global.TRUE, text("保存plan成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("plan:plan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Plan plan) {
		planService.delete(plan);
		return renderResult(Global.TRUE, text("删除plan成功！"));
	}
	
}