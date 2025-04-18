package com.rubypaper.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Table(name="BOARD")
@Getter
@Setter
@ToString
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private Long seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private Long cnt;

}
