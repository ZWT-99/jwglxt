/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.course.web;

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
import com.jeesite.modules.course.entity.Course;
import com.jeesite.modules.course.service.CourseService;

/**
 * courseController
 * @author sdy
 * @version 2021-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/course/course")
public class CourseController extends BaseController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Course get(String cno, boolean isNewRecord) {
		return courseService.get(cno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("course:course:view")
	@RequestMapping(value = {"list", ""})
	public String list(Course course, Model model) {
		model.addAttribute("course", course);
		return "modules/course/courseList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("course:course:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Course> listData(Course course, HttpServletRequest request, HttpServletResponse response) {
		course.setPage(new Page<>(request, response));
		Page<Course> page = courseService.findPage(course);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("course:course:view")
	@RequestMapping(value = "form")
	public String form(Course course, Model model) {
		model.addAttribute("course", course);
		return "modules/course/courseForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("course:course:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Course course) {
		courseService.save(course);
		return renderResult(Global.TRUE, text("保存course成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("course:course:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Course course) {
		courseService.delete(course);
		return renderResult(Global.TRUE, text("删除course成功！"));
	}
	
}