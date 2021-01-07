/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.course.entity;

import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * courseEntity
 * @author sdy
 * @version 2021-01-07
 */
@Table(name="course", alias="a", columns={
		@Column(name="cno", attrName="cno", label="cno", isPK=true),
		@Column(name="cname", attrName="cname", label="cname"),
		@Column(name="cmark", attrName="cmark", label="cmark"),
		@Column(name="tno", attrName="tno", label="tno"),
		@Column(name="ctime", attrName="ctime", label="ctime"),
		@Column(name="cplace", attrName="cplace", label="cplace"),
		@Column(name="ckind", attrName="ckind", label="ckind"),
		@Column(name="cdesc", attrName="cdesc", label="cdesc"),
	}, orderBy="a.cno DESC"
)
public class Course extends DataEntity<Course> {
	
	private static final long serialVersionUID = 1L;
	private String cno;		// cno
	private String cname;		// cname
	private BigDecimal cmark;		// cmark
	private String tno;		// tno
	private String ctime;		// ctime
	private String cplace;		// cplace
	private String ckind;		// ckind
	private String cdesc;		// cdesc
	
	public Course() {
		this(null);
	}

	public Course(String id){
		super(id);
	}
	
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	@Length(min=0, max=20, message="cname长度不能超过 20 个字符")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public BigDecimal getCmark() {
		return cmark;
	}

	public void setCmark(BigDecimal cmark) {
		this.cmark = cmark;
	}
	
	@Length(min=0, max=20, message="tno长度不能超过 20 个字符")
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=0, max=20, message="ctime长度不能超过 20 个字符")
	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	@Length(min=0, max=20, message="cplace长度不能超过 20 个字符")
	public String getCplace() {
		return cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}
	
	@Length(min=0, max=20, message="ckind长度不能超过 20 个字符")
	public String getCkind() {
		return ckind;
	}

	public void setCkind(String ckind) {
		this.ckind = ckind;
	}
	
	@Length(min=0, max=100, message="cdesc长度不能超过 100 个字符")
	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
}