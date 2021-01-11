/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.plan.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * planEntity
 * @author gjc
 * @version 2021-01-11
 */
@Table(name="plan", alias="a", columns={
		@Column(name="planid", attrName="planid", label="planid", isPK=true),
		@Column(name="term", attrName="学期", label="学期", isPK=true),
		@Column(name="year", attrName="年", label="年", isPK=true),
		@Column(name="cno", attrName="课程编码", label="课程编码", isPK=true),
		@Column(name="rl", attrName="详情", label="详情"),
	}, orderBy="a.planid DESC, a.term DESC, a.year DESC, a.cno DESC"
)
public class Plan extends DataEntity<Plan> {
	
	private static final long serialVersionUID = 1L;
	private String planid;		// planid
	private String 学期;		// 学期
	private String 年;		// 年
	private String 课程编码;		// 课程编码
	private String 详情;		// 详情
	
	public Plan() {
		this(null, null, null, null);
	}

	public Plan(String planid, String 学期, String 年, String 课程编码){
		this.planid = planid;
		this.学期 = 学期;
		this.年 = 年;
		this.课程编码 = 课程编码;
	}
	
	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}
	
	public String get学期() {
		return 学期;
	}

	public void set学期(String 学期) {
		this.学期 = 学期;
	}
	
	public String get年() {
		return 年;
	}

	public void set年(String 年) {
		this.年 = 年;
	}
	
	public String get课程编码() {
		return 课程编码;
	}

	public void set课程编码(String 课程编码) {
		this.课程编码 = 课程编码;
	}
	
	@Length(min=0, max=100, message="详情长度不能超过 100 个字符")
	public String get详情() {
		return 详情;
	}

	public void set详情(String 详情) {
		this.详情 = 详情;
	}
	
}