/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.web;

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
import com.jeesite.modules.departs.entity.Departs;
import com.jeesite.modules.departs.service.DepartsService;

/**
 * departsController
 * @author sdy
 * @version 2021-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/departs/departs")
public class DepartsController extends BaseController {

	@Autowired
	private DepartsService departsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Departs get(String dname, boolean isNewRecord) {
		return departsService.get(dname, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("departs:departs:view")
	@RequestMapping(value = {"list", ""})
	public String list(Departs departs, Model model) {
		model.addAttribute("departs", departs);
		return "modules/departs/departsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("departs:departs:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Departs> listData(Departs departs, HttpServletRequest request, HttpServletResponse response) {
		departs.setPage(new Page<>(request, response));
		Page<Departs> page = departsService.findPage(departs);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("departs:departs:view")
	@RequestMapping(value = "form")
	public String form(Departs departs, Model model) {
		model.addAttribute("departs", departs);
		return "modules/departs/departsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("departs:departs:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Departs departs) {
		departsService.save(departs);
		return renderResult(Global.TRUE, text("保存departs成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("departs:departs:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Departs departs) {
		departsService.delete(departs);
		return renderResult(Global.TRUE, text("删除departs成功！"));
	}
	
}