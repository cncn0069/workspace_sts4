package com.rubypaper.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JDBCConnect {
	
	private Connection con = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement psmt = null;
	
	public JDBCConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd ="napkin";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
//			if(con != null)
//				con.close();
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(psmt != null)
				psmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
