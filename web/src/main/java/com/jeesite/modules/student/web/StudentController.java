/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.web;

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
import com.jeesite.modules.student.entity.Student;
import com.jeesite.modules.student.service.StudentService;

/**
 * studentController
 * @author sdy
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/student/student")
public class StudentController extends BaseController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Student get(String sno, boolean isNewRecord) {
		return studentService.get(sno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = {"list", ""})
	public String list(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/student/studentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Student> listData(Student student, HttpServletRequest request, HttpServletResponse response) {
		student.setPage(new Page<>(request, response));
		Page<Student> page = studentService.findPage(student);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = "form")
	public String form(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/student/studentForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("student:student:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Student student) {
		studentService.save(student);
		return renderResult(Global.TRUE, text("保存student成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("student:student:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Student student) {
		studentService.delete(student);
		return renderResult(Global.TRUE, text("删除student成功！"));
	}
	
}