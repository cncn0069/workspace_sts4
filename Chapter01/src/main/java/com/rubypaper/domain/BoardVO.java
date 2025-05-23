package com.rubypaper.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt;

}
//BoardBuilder builder() {
//	return new BoardBuilder();
//}
//
//static class BoardBuilder{
//	private int seq;
//	private String title;
//	private String writer;
//	private String content;
//	private Date createDate = new Date();
//	private int cnt;
//	
//	BoardBuilder seq(int seq) {
//		this.seq = seq;
//		return this;
//	}
//	
//	BoardBuilder title(int title) {
//		this.seq = title;
//		return this;
//	}
//	
//	BoardBuilder writer(int writer) {
//		this.seq = writer;
//		return this;
//	}
//	BoardBuilder content(int content) {
//		this.seq = content;
//		return this;
//	}
//	BoardBuilder createDate(int createDate) {
//		this.seq = createDate;
//		return this;
//	}
//	BoardBuilder cnt(int cnt) {
//		this.seq = cnt;
//		return this;
//	}
//}
//
//BoardVO build() {
//	return BoardVO(seq,title,writer,content,createDate,cnt);
//}