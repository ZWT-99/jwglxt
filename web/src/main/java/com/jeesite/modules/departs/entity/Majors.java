/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * departsEntity
 * @author sdy
 * @version 2021-01-08
 */
@Table(name="majors", alias="a", columns={
		@Column(name="dname", attrName="dname.dname", label="学院名称"),
		@Column(name="major", attrName="major", label="专业"),
		@Column(name="mid", attrName="mid", label="mid", isPK=true),
	}, orderBy="a.mid ASC"
)
public class Majors extends DataEntity<Majors> {
	
	private static final long serialVersionUID = 1L;
	private Departs dname;		// 学院名称 父类
	private String major;		// 专业
	private String mid;		// mid
	
	public Majors() {
		this(null);
	}


	public Majors(Departs dname){
		this.dname = dname;
	}
	
	@Length(min=0, max=20, message="学院名称长度不能超过 20 个字符")
	public Departs getDname() {
		return dname;
	}

	public void setDname(Departs dname) {
		this.dname = dname;
	}
	
	@NotBlank(message="专业不能为空")
	@Length(min=0, max=20, message="专业长度不能超过 20 个字符")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
}