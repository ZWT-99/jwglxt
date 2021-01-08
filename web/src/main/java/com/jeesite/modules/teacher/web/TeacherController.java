/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher.web;

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
import com.jeesite.modules.teacher.entity.Teacher;
import com.jeesite.modules.teacher.service.TeacherService;

/**
 * teacherController
 * @author sdy
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/teacher/teacher")
public class TeacherController extends BaseController {

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Teacher get(String tno, boolean isNewRecord) {
		return teacherService.get(tno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("teacher:teacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(Teacher teacher, Model model) {
		model.addAttribute("teacher", teacher);
		return "modules/teacher/teacherList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("teacher:teacher:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Teacher> listData(Teacher teacher, HttpServletRequest request, HttpServletResponse response) {
		teacher.setPage(new Page<>(request, response));
		Page<Teacher> page = teacherService.findPage(teacher);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("teacher:teacher:view")
	@RequestMapping(value = "form")
	public String form(Teacher teacher, Model model) {
		model.addAttribute("teacher", teacher);
		return "modules/teacher/teacherForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("teacher:teacher:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Teacher teacher) {
		teacherService.save(teacher);
		return renderResult(Global.TRUE, text("保存teacher成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("teacher:teacher:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Teacher teacher) {
		teacherService.delete(teacher);
		return renderResult(Global.TRUE, text("删除teacher成功！"));
	}
	
}