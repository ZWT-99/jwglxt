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
		@Column(name="term", attrName="term", label="学期", isPK=true),
		@Column(name="year", attrName="year", label="年份", isPK=true),
		@Column(name="cno", attrName="cno", label="课程编码", isPK=true),
		@Column(name="rl", attrName="rl", label="详情"),
	}, orderBy="a.planid DESC, a.term DESC, a.year DESC, a.cno DESC"
)
public class Plan extends DataEntity<Plan> {
	
	private static final long serialVersionUID = 1L;
	private String planid;		// planid
	private String term;		// 学期
	private String year;		// 年份
	private String cno;		// 课程编码
	private String rl;		// 详情
	
	public Plan() {
		this(null, null, null, null);
	}

	public Plan(String planid, String term, String year, String cno){
		this.planid = planid;
		this.term = term;
		this.year = year;
		this.cno = cno;
	}
	
	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	@Length(min=0, max=20, message="详情长度不能超过 20 个字符")
	public String getRl() {
		return rl;
	}

	public void setRl(String rl) {
		this.rl = rl;
	}
	
}