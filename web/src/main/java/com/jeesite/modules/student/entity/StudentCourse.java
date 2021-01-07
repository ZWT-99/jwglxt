/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * studentEntity
 * @author sdy
 * @version 2021-01-07
 */
@Table(name="student_course", alias="a", columns={
		@Column(name="sno_id", attrName="snoId.sno", label="学号"),
		@Column(name="cno", attrName="cno", label="课程号"),
		@Column(name="cscore", attrName="cscore", label="分数"),
		@Column(name="statu", attrName="statu", label="状态"),
		@Column(name="grade", attrName="grade", label="grade", isPK=true),
	}, orderBy="a.grade ASC"
)
public class StudentCourse extends DataEntity<StudentCourse> {
	
	private static final long serialVersionUID = 1L;
	private Student snoId;		// 学号 父类
	private String cno;		// 课程号
	private Long cscore;		// 分数
	private Long statu;		// 状态
	private String grade;		// grade
	
	public StudentCourse() {
		this(null);
	}


	public StudentCourse(Student snoId){
		this.snoId = snoId;
	}
	
	@Length(min=0, max=20, message="学号长度不能超过 20 个字符")
	public Student getSnoId() {
		return snoId;
	}

	public void setSnoId(Student snoId) {
		this.snoId = snoId;
	}
	
	@Length(min=0, max=10, message="课程号长度不能超过 10 个字符")
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	public Long getCscore() {
		return cscore;
	}

	public void setCscore(Long cscore) {
		this.cscore = cscore;
	}
	
	public Long getStatu() {
		return statu;
	}

	public void setStatu(Long statu) {
		this.statu = statu;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}