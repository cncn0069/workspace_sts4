package com.rubypaper.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt;
	
	public static BoardBuilder builder() {
		return new BoardBuilder();
	}

	public static class BoardBuilder {
		private int seq;
		private String title;
		private String writer;
		private String content;
		private Date createDate;
		private int cnt;

		public BoardBuilder seq(int seq) {
			this.seq = seq;
			return this;
		}

		public BoardBuilder title(String title) {
			this.title = title;
			return this;
		}

		public BoardBuilder writer(String writer) {
			this.writer = writer;
			return this;
		}

		public BoardBuilder content(String content) {
			this.content = content;
			return this;
		}

		public BoardBuilder createDate(Date createDate) {
			this.createDate = createDate;
			return this;
		}

		public BoardBuilder cnt(int cnt) {
			this.cnt = cnt;
			return this;
		}
		
		public BoardVO build() {
			return new BoardVO(seq, title, writer, content, createDate, cnt);
		}
	}

	
}