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
 * @version 2021-01-08
 */
@Table(name="teacher", alias="a", columns={
		@Column(name="tno", attrName="tno", label="教师编号", isPK=true),
		@Column(name="tname", attrName="tname", label="姓名"),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="department", attrName="department", label="学院"),
		@Column(name="nationality", attrName="nationality", label="民族"),
		@Column(name="nativeplace", attrName="nativeplace", label="籍贯"),
		@Column(name="telephone", attrName="telephone", label="电话"),
		@Column(name="tbirth", attrName="tbirth", label="生日"),
	}, orderBy="a.tno DESC"
)
public class Teacher extends DataEntity<Teacher> {
	
	private static final long serialVersionUID = 1L;
	private String tno;		// 教师编号
	private String tname;		// 姓名
	private Long sex;		// 性别
	private String department;		// 学院
	private String nationality;		// 民族
	private String nativeplace;		// 籍贯
	private String telephone;		// 电话
	private Date tbirth;		// 生日
	
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
	
	@Length(min=0, max=20, message="姓名长度不能超过 20 个字符")
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
	
	@Length(min=0, max=20, message="学院长度不能超过 20 个字符")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=20, message="民族长度不能超过 20 个字符")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Length(min=0, max=40, message="籍贯长度不能超过 40 个字符")
	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	@Length(min=0, max=20, message="电话长度不能超过 20 个字符")
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