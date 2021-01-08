/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * departsEntity
 * @author sdy
 * @version 2021-01-08
 */
@Table(name="departs", alias="a", columns={
		@Column(name="dname", attrName="dname", label="dname", isPK=true),
		@Column(name="dinfor", attrName="dinfor", label="学院信息"),
	}, orderBy="a.dname DESC"
)
public class Departs extends DataEntity<Departs> {
	
	private static final long serialVersionUID = 1L;
	private String dname;		// dname
	private String dinfor;		// 学院信息
	private List<DepartsTeacher> departsTeacherList = ListUtils.newArrayList();		// 子表列表
	
	public Departs() {
		this(null);
	}

	public Departs(String id){
		super(id);
	}
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Length(min=0, max=255, message="学院信息长度不能超过 255 个字符")
	public String getDinfor() {
		return dinfor;
	}

	public void setDinfor(String dinfor) {
		this.dinfor = dinfor;
	}
	
	public List<DepartsTeacher> getDepartsTeacherList() {
		return departsTeacherList;
	}

	public void setDepartsTeacherList(List<DepartsTeacher> departsTeacherList) {
		this.departsTeacherList = departsTeacherList;
	}
	
}