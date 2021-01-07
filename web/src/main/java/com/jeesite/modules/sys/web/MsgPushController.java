/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.web;

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
import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.MsgPush;
import com.jeesite.modules.sys.service.MsgPushService;

/**
 * 消息推送表Controller
 * @author gjc
 * @version 2021-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/msgPush")
public class MsgPushController extends BaseController {

	@Autowired
	private MsgPushService msgPushService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MsgPush get(String id, boolean isNewRecord) {
		return msgPushService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:msgPush:view")
	@RequestMapping(value = {"list", ""})
	public String list(MsgPush msgPush, Model model) {
		model.addAttribute("msgPush", msgPush);
		return "modules/sys/msgPushList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sys:msgPush:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MsgPush> listData(MsgPush msgPush, HttpServletRequest request, HttpServletResponse response) {
		msgPush.setPage(new Page<>(request, response));
		Page<MsgPush> page = msgPushService.findPage(msgPush);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sys:msgPush:view")
	@RequestMapping(value = "form")
	public String form(MsgPush msgPush, Model model) {
		model.addAttribute("msgPush", msgPush);
		return "modules/sys/msgPushForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("sys:msgPush:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MsgPush msgPush) {
		msgPushService.save(msgPush);
		return renderResult(Global.TRUE, text("保存消息推送表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("sys:msgPush:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MsgPush msgPush) {
		msgPushService.delete(msgPush);
		return renderResult(Global.TRUE, text("删除消息推送表成功！"));
	}
	
	/**
	 * 列表选择对话框
	 */
	@RequiresPermissions("sys:msgPush:view")
	@RequestMapping(value = "msgPushSelect")
	public String empUserSelect(MsgPush msgPush, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		model.addAttribute("MsgPush", msgPush);
		return "modules/sys/msgPushSelect";
	}
	
}