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
		@Column(name="sno", attrName="sno", label="学号", isPK=true),
		@Column(name="sname", attrName="sname", label="姓名"),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="nationality", attrName="nationality", label="民族"),
		@Column(name="nativeplace", attrName="nativeplace", label="籍贯"),
		@Column(name="major", attrName="major", label="专业"),
		@Column(name="telephone", attrName="telephone", label="电话"),
		@Column(name="sbirth", attrName="sbirth", label="生日"),
		@Column(name="gradeid", attrName="gradeid", label="gradeid"),
	}, orderBy="a.sno DESC"
)
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学号
	private String sname;		// 姓名
	private Long sex;		// 性别
	private String nationality;		// 民族
	private String nativeplace;		// 籍贯
	private String major;		// 专业
	private String telephone;		// 电话
	private Date sbirth;		// 生日
	private String gradeid;		// gradeid
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
	
	@Length(min=0, max=20, message="姓名长度不能超过 20 个字符")
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
	
	@Length(min=0, max=20, message="民族长度不能超过 20 个字符")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Length(min=0, max=20, message="籍贯长度不能超过 20 个字符")
	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	@Length(min=0, max=20, message="专业长度不能超过 20 个字符")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Length(min=0, max=20, message="电话长度不能超过 20 个字符")
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
	
	public String getGradeid() {
		return gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}
	
	public List<StudentCourse> getStudentCourseList() {
		return studentCourseList;
	}

	public void setStudentCourseList(List<StudentCourse> studentCourseList) {
		this.studentCourseList = studentCourseList;
	}
	
}