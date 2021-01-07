/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sys.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 消息推送表Entity
 * @author gjc
 * @version 2021-01-07
 */
@Table(name="${_prefix}sys_msg_push", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="msg_type", attrName="msgType", label="消息类型", comment="消息类型（PC APP 短信 邮件 微信）"),
		@Column(name="msg_title", attrName="msgTitle", label="消息标题", queryType=QueryType.LIKE),
		@Column(name="msg_content", attrName="msgContent", label="消息内容"),
		@Column(name="biz_key", attrName="bizKey", label="业务主键"),
		@Column(name="biz_type", attrName="bizType", label="业务类型"),
		@Column(name="receive_code", attrName="receiveCode", label="接受者账号"),
		@Column(name="receive_user_code", attrName="receiveUserCode", label="接受者用户编码"),
		@Column(name="receive_user_name", attrName="receiveUserName", label="接受者用户姓名", queryType=QueryType.LIKE),
		@Column(name="send_user_code", attrName="sendUserCode", label="发送者用户编码"),
		@Column(name="send_user_name", attrName="sendUserName", label="发送者用户姓名", queryType=QueryType.LIKE),
		@Column(name="send_date", attrName="sendDate", label="发送时间"),
		@Column(name="is_merge_push", attrName="isMergePush", label="是否合并推送"),
		@Column(name="plan_push_date", attrName="planPushDate", label="计划推送时间"),
		@Column(name="push_number", attrName="pushNumber", label="推送尝试次数"),
		@Column(name="push_return_code", attrName="pushReturnCode", label="推送返回结果码"),
		@Column(name="push_return_msg_id", attrName="pushReturnMsgId", label="推送返回消息编号"),
		@Column(name="push_return_content", attrName="pushReturnContent", label="推送返回的内容信息"),
		@Column(name="push_status", attrName="pushStatus", label="推送状态", comment="推送状态（0未推送 1成功  2失败）"),
		@Column(name="push_date", attrName="pushDate", label="推送时间"),
		@Column(name="read_status", attrName="readStatus", label="读取状态", comment="读取状态（0未送达 1已读 2未读）"),
		@Column(name="read_date", attrName="readDate", label="读取时间"),
	}, orderBy="a.id DESC"
)
public class MsgPush extends DataEntity<MsgPush> {
	
	private static final long serialVersionUID = 1L;
	private String msgType;		// 消息类型（PC APP 短信 邮件 微信）
	private String msgTitle;		// 消息标题
	private String msgContent;		// 消息内容
	private String bizKey;		// 业务主键
	private String bizType;		// 业务类型
	private String receiveCode;		// 接受者账号
	private String receiveUserCode;		// 接受者用户编码
	private String receiveUserName;		// 接受者用户姓名
	private String sendUserCode;		// 发送者用户编码
	private String sendUserName;		// 发送者用户姓名
	private Date sendDate;		// 发送时间
	private String isMergePush;		// 是否合并推送
	private Date planPushDate;		// 计划推送时间
	private Long pushNumber;		// 推送尝试次数
	private String pushReturnCode;		// 推送返回结果码
	private String pushReturnMsgId;		// 推送返回消息编号
	private String pushReturnContent;		// 推送返回的内容信息
	private String pushStatus;		// 推送状态（0未推送 1成功  2失败）
	private Date pushDate;		// 推送时间
	private String readStatus;		// 读取状态（0未送达 1已读 2未读）
	private Date readDate;		// 读取时间
	
	public MsgPush() {
		this(null);
	}

	public MsgPush(String id){
		super(id);
	}
	
	@NotBlank(message="消息类型不能为空")
	@Length(min=0, max=16, message="消息类型长度不能超过 16 个字符")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@NotBlank(message="消息标题不能为空")
	@Length(min=0, max=200, message="消息标题长度不能超过 200 个字符")
	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	
	@NotBlank(message="消息内容不能为空")
	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
	@Length(min=0, max=64, message="业务主键长度不能超过 64 个字符")
	public String getBizKey() {
		return bizKey;
	}

	public void setBizKey(String bizKey) {
		this.bizKey = bizKey;
	}
	
	@Length(min=0, max=64, message="业务类型长度不能超过 64 个字符")
	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	
	@NotBlank(message="接受者账号不能为空")
	@Length(min=0, max=64, message="接受者账号长度不能超过 64 个字符")
	public String getReceiveCode() {
		return receiveCode;
	}

	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}
	
	@NotBlank(message="接受者用户编码不能为空")
	@Length(min=0, max=64, message="接受者用户编码长度不能超过 64 个字符")
	public String getReceiveUserCode() {
		return receiveUserCode;
	}

	public void setReceiveUserCode(String receiveUserCode) {
		this.receiveUserCode = receiveUserCode;
	}
	
	@NotBlank(message="接受者用户姓名不能为空")
	@Length(min=0, max=100, message="接受者用户姓名长度不能超过 100 个字符")
	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}
	
	@NotBlank(message="发送者用户编码不能为空")
	@Length(min=0, max=64, message="发送者用户编码长度不能超过 64 个字符")
	public String getSendUserCode() {
		return sendUserCode;
	}

	public void setSendUserCode(String sendUserCode) {
		this.sendUserCode = sendUserCode;
	}
	
	@NotBlank(message="发送者用户姓名不能为空")
	@Length(min=0, max=100, message="发送者用户姓名长度不能超过 100 个字符")
	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发送时间不能为空")
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@Length(min=0, max=1, message="是否合并推送长度不能超过 1 个字符")
	public String getIsMergePush() {
		return isMergePush;
	}

	public void setIsMergePush(String isMergePush) {
		this.isMergePush = isMergePush;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPlanPushDate() {
		return planPushDate;
	}

	public void setPlanPushDate(Date planPushDate) {
		this.planPushDate = planPushDate;
	}
	
	public Long getPushNumber() {
		return pushNumber;
	}

	public void setPushNumber(Long pushNumber) {
		this.pushNumber = pushNumber;
	}
	
	@Length(min=0, max=200, message="推送返回结果码长度不能超过 200 个字符")
	public String getPushReturnCode() {
		return pushReturnCode;
	}

	public void setPushReturnCode(String pushReturnCode) {
		this.pushReturnCode = pushReturnCode;
	}
	
	@Length(min=0, max=200, message="推送返回消息编号长度不能超过 200 个字符")
	public String getPushReturnMsgId() {
		return pushReturnMsgId;
	}

	public void setPushReturnMsgId(String pushReturnMsgId) {
		this.pushReturnMsgId = pushReturnMsgId;
	}
	
	public String getPushReturnContent() {
		return pushReturnContent;
	}

	public void setPushReturnContent(String pushReturnContent) {
		this.pushReturnContent = pushReturnContent;
	}
	
	@Length(min=0, max=1, message="推送状态长度不能超过 1 个字符")
	public String getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPushDate() {
		return pushDate;
	}

	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}
	
	@Length(min=0, max=1, message="读取状态长度不能超过 1 个字符")
	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	
}