/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teaching.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.entity.TreeEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 行政区划Entity
 * @author sdy
 * @version 2021-01-10
 */
@Table(name="teaching_plan", alias="a", columns={
		@Column(name="major_code", attrName="majorCode", label="专业编码", isPK=true),
		@Column(includeEntity=TreeEntity.class),
		@Column(name="major_name", attrName="majorName", label="专业名称", queryType=QueryType.LIKE),
		@Column(name="major_type", attrName="majorType", label="专业类型"),
		@Column(name="status", attrName="status", label="状态", comment="状态（0正常 1删除 2停用）", isUpdate=false),
		@Column(name="remarks", attrName="remarks", label="备注信息", queryType=QueryType.LIKE),
	}, orderBy="a.tree_sorts, a.major_code"
)
public class TeachingPlan extends TreeEntity<TeachingPlan> {
	
	private static final long serialVersionUID = 1L;
	private String majorCode;		// 专业编码
	private String majorName;		// 专业名称
	private String majorType;		// 专业类型
	
	public TeachingPlan() {
		this(null);
	}

	public TeachingPlan(String id){
		super(id);
	}
	
	@Override
	public TeachingPlan getParent() {
		return parent;
	}

	@Override
	public void setParent(TeachingPlan parent) {
		this.parent = parent;
	}
	
	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	
	@NotBlank(message="专业名称不能为空")
	@Length(min=0, max=100, message="专业名称长度不能超过 100 个字符")
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	@Length(min=0, max=1, message="专业类型长度不能超过 1 个字符")
	public String getMajorType() {
		return majorType;
	}

	public void setMajorType(String majorType) {
		this.majorType = majorType;
	}
	
}