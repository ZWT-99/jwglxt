/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.departs.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * departsEntity
 * @author sdy
 * @version 2021-01-07
 */
@Table(name="departs", alias="a", columns={
		@Column(name="dname", attrName="dname", label="dname", isPK=true),
	}, orderBy="a.dname DESC"
)
public class Departs extends DataEntity<Departs> {
	
	private static final long serialVersionUID = 1L;
	private String dname;		// dname
	
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
	
}