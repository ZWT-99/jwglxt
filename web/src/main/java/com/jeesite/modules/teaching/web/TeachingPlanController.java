/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teaching.web;

import java.util.List;
import java.util.Map;

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
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.teaching.entity.TeachingPlan;
import com.jeesite.modules.teaching.service.TeachingPlanService;

/**
 * 教学计划管理Controller
 * @author sdy
 * @version 2021-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/teaching/teachingPlan")
public class TeachingPlanController extends BaseController {

	@Autowired
	private TeachingPlanService teachingPlanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TeachingPlan get(String majorCode, boolean isNewRecord) {
		return teachingPlanService.get(majorCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("teaching:teachingPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TeachingPlan teachingPlan, Model model) {
		model.addAttribute("teachingPlan", teachingPlan);
		return "modules/teaching/teachingPlanList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("teaching:teachingPlan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<TeachingPlan> listData(TeachingPlan teachingPlan) {
		if (StringUtils.isBlank(teachingPlan.getParentCode())) {
			teachingPlan.setParentCode(TeachingPlan.ROOT_CODE);
		}
		if (StringUtils.isNotBlank(teachingPlan.getMajorName())){
			teachingPlan.setParentCode(null);
		}
		if (StringUtils.isNotBlank(teachingPlan.getMajorType())){
			teachingPlan.setParentCode(null);
		}
		if (StringUtils.isNotBlank(teachingPlan.getRemarks())){
			teachingPlan.setParentCode(null);
		}
		List<TeachingPlan> list = teachingPlanService.findList(teachingPlan);
		return list;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("teaching:teachingPlan:view")
	@RequestMapping(value = "form")
	public String form(TeachingPlan teachingPlan, Model model) {
		// 创建并初始化下一个节点信息
		teachingPlan = createNextNode(teachingPlan);
		model.addAttribute("teachingPlan", teachingPlan);
		return "modules/teaching/teachingPlanForm";
	}
	
	/**
	 * 创建并初始化下一个节点信息，如：排序号、默认值
	 */
	@RequiresPermissions("teaching:teachingPlan:edit")
	@RequestMapping(value = "createNextNode")
	@ResponseBody
	public TeachingPlan createNextNode(TeachingPlan teachingPlan) {
		if (StringUtils.isNotBlank(teachingPlan.getParentCode())){
			teachingPlan.setParent(teachingPlanService.get(teachingPlan.getParentCode()));
		}
		if (teachingPlan.getIsNewRecord()) {
			TeachingPlan where = new TeachingPlan();
			where.setParentCode(teachingPlan.getParentCode());
			TeachingPlan last = teachingPlanService.getLastByParentCode(where);
			// 获取到下级最后一个节点
			if (last != null){
				teachingPlan.setTreeSort(last.getTreeSort() + 30);
				teachingPlan.setMajorCode(IdGen.nextCode(last.getMajorCode()));
			}else if (teachingPlan.getParent() != null){
				teachingPlan.setMajorCode(teachingPlan.getParent().getMajorCode() + "001");
			}
		}
		// 以下设置表单默认数据
		if (teachingPlan.getTreeSort() == null){
			teachingPlan.setTreeSort(TeachingPlan.DEFAULT_TREE_SORT);
		}
		return teachingPlan;
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("teaching:teachingPlan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TeachingPlan teachingPlan) {
		teachingPlanService.save(teachingPlan);
		return renderResult(Global.TRUE, text("保存教学计划管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("teaching:teachingPlan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TeachingPlan teachingPlan) {
		teachingPlanService.delete(teachingPlan);
		return renderResult(Global.TRUE, text("删除教学计划管理成功！"));
	}
	
	/**
	 * 获取树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequiresPermissions("teaching:teachingPlan:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, String isShowCode) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<TeachingPlan> list = teachingPlanService.findList(new TeachingPlan());
		for (int i=0; i<list.size(); i++){
			TeachingPlan e = list.get(i);
			// 过滤非正常的数据
			if (!TeachingPlan.STATUS_NORMAL.equals(e.getStatus())){
				continue;
			}
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotBlank(excludeCode)){
				if (e.getId().equals(excludeCode)){
					continue;
				}
				if (e.getParentCodes().contains("," + excludeCode + ",")){
					continue;
				}
			}
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentCode());
			map.put("name", StringUtils.getTreeNodeName(isShowCode, e.getMajorCode(), e.getMajorCode()));
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 修复表结构相关数据
	 */
	@RequiresPermissions("teaching:teachingPlan:edit")
	@RequestMapping(value = "fixTreeData")
	@ResponseBody
	public String fixTreeData(TeachingPlan teachingPlan){
		if (!UserUtils.getUser().isAdmin()){
			return renderResult(Global.FALSE, "操作失败，只有管理员才能进行修复！");
		}
		teachingPlanService.fixTreeData();
		return renderResult(Global.TRUE, "数据修复成功");
	}
	
}