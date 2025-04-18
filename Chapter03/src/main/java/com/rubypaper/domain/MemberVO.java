package com.rubypaper.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
	private Integer id;
	private String pass;
	private String name;
	private Date regidate;
	
	
	public static MemberBuilder builder() {
		return new MemberBuilder();
	}
	
	public static class MemberBuilder{
		private Integer id;
		private String pass;
		private String name;
		private Date regidate;
		
		public MemberBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public MemberBuilder pass(String pass) {
			this.pass = pass;
			return this;
		}
		
		public MemberBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public MemberBuilder id(Date regidate) {
			this.regidate = regidate;
			return this;
		}
		
		public MemberVO build() {
			return new MemberVO(id,pass,name,regidate);
		}
	}
}
