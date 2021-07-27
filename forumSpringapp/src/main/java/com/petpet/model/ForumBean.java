package com.petpet.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "forum_list")
public class ForumBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer textId;
	// 會員Bean的帳號
	private String email;
	private String title;
	private String text;
	private Integer gp;
	private Integer bp;
	private Integer interactive_num;
	private Integer reply_num;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Taipei")
	private Timestamp create_time;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Taipei")
	private Timestamp reply_time;
	private String text_sub;
	private String text_type;

	public Integer getTextId() {
		return textId;
	}

	public void setTextId(Integer textId) {
		this.textId = textId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getGp() {
		return gp;
	}

	public void setGp(Integer gp) {
		this.gp = gp;
	}

	public Integer getBp() {
		return bp;
	}

	public void setBp(Integer bp) {
		this.bp = bp;
	}

	public Integer getInteractive_num() {
		return interactive_num;
	}

	public void setInteractive_num(Integer interactive_num) {
		this.interactive_num = interactive_num;
	}

	public Integer getReply_num() {
		return reply_num;
	}

	public void setReply_num(Integer reply_num) {
		this.reply_num = reply_num;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getReply_time() {
		return reply_time;
	}

	public void setReply_time(Timestamp reply_time) {
		this.reply_time = reply_time;
	}

	public String getText_sub() {
		return text_sub;
	}

	public void setText_sub(String text_sub) {
		this.text_sub = text_sub;
	}

	public String getText_type() {
		return text_type;
	}

	public void setText_type(String text_type) {
		this.text_type = text_type;
	}

	@Override
	public String toString() {
		return "ForumBean [textId=" + textId + ", email=" + email + ", title=" + title + ", text=" + text + ", gp=" + gp
				+ ", bp=" + bp + ", interactive_num=" + interactive_num + ", reply_num=" + reply_num + ", create_time="
				+ create_time + ", reply_time=" + reply_time + ", text_sub=" + text_sub + ", text_type=" + text_type
				+ "]";
	}

}
