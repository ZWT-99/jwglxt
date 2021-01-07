/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * studentEntity
 * @author sdy
 * @version 2021-01-07
 */
@Table(name="student", alias="a", columns={
		@Column(name="sno", attrName="sno", label="sno", isPK=true),
		@Column(name="sname", attrName="sname", label="sname"),
		@Column(name="sex", attrName="sex", label="sex"),
		@Column(name="nationality", attrName="nationality", label="nationality"),
		@Column(name="nativeplace", attrName="nativeplace", label="nativeplace"),
		@Column(name="major", attrName="major", label="major"),
		@Column(name="telephone", attrName="telephone", label="telephone"),
		@Column(name="sbirth", attrName="sbirth", label="sbirth"),
	}, orderBy="a.sno DESC"
)
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// sno
	private String sname;		// sname
	private Long sex;		// sex
	private String nationality;		// nationality
	private String nativeplace;		// nativeplace
	private String major;		// major
	private String telephone;		// telephone
	private Date sbirth;		// sbirth
	private List<StudentCourse> studentCourseList = ListUtils.newArrayList();		// 子表列表
	
	public Student() {
		this(null);
	}

	public Student(String id){
		super(id);
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=20, message="sname长度不能超过 20 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="nationality长度不能超过 20 个字符")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Length(min=0, max=20, message="nativeplace长度不能超过 20 个字符")
	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	@Length(min=0, max=20, message="major长度不能超过 20 个字符")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Length(min=0, max=20, message="telephone长度不能超过 20 个字符")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSbirth() {
		return sbirth;
	}

	public void setSbirth(Date sbirth) {
		this.sbirth = sbirth;
	}
	
	public List<StudentCourse> getStudentCourseList() {
		return studentCourseList;
	}

	public void setStudentCourseList(List<StudentCourse> studentCourseList) {
		this.studentCourseList = studentCourseList;
	}
	
}