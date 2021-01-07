/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * teacherEntity
 * @author sdy
 * @version 2021-01-06
 */
@Table(name="teacher", alias="a", columns={
		@Column(name="tno", attrName="tno", label="tno", isPK=true),
		@Column(name="tname", attrName="tname", label="tname"),
		@Column(name="sex", attrName="sex", label="sex"),
		@Column(name="department", attrName="department", label="department"),
		@Column(name="nationality", attrName="nationality", label="nationality"),
		@Column(name="nativeplace", attrName="nativeplace", label="nativeplace"),
		@Column(name="telephone", attrName="telephone", label="telephone"),
		@Column(name="tbirth", attrName="tbirth", label="tbirth"),
	}, orderBy="a.tno DESC"
)
public class Teacher extends DataEntity<Teacher> {
	
	private static final long serialVersionUID = 1L;
	private String tno;		// tno
	private String tname;		// tname
	private Long sex;		// sex
	private String department;		// department
	private String nationality;		// nationality
	private String nativeplace;		// nativeplace
	private String telephone;		// telephone
	private Date tbirth;		// tbirth
	
	public Teacher() {
		this(null);
	}

	public Teacher(String id){
		super(id);
	}
	
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=0, max=20, message="tname长度不能超过 20 个字符")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="department长度不能超过 20 个字符")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=20, message="nationality长度不能超过 20 个字符")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Length(min=0, max=40, message="nativeplace长度不能超过 40 个字符")
	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	@Length(min=0, max=20, message="telephone长度不能超过 20 个字符")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTbirth() {
		return tbirth;
	}

	public void setTbirth(Date tbirth) {
		this.tbirth = tbirth;
	}
	
}