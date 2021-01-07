/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.entity;


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
		@Column(name="sno", attrName="sno", label="sno", isPK=true),
		@Column(name="cno", attrName="cno.sno", label="cno", isPK=true),
		@Column(name="cscore", attrName="cscore", label="cscore"),
		@Column(name="statu", attrName="statu", label="statu"),
	}, orderBy="a.sno ASC, a.cno ASC"
)
public class StudentCourse extends DataEntity<StudentCourse> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// sno
	private Student cno;		// cno 父类
	private Long cscore;		// cscore
	private Long statu;		// statu
	
	public StudentCourse() {
		this(null);
	}


	public StudentCourse(Student cno){
		this.cno = cno;
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	public Student getCno() {
		return cno;
	}

	public void setCno(Student cno) {
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
	
}