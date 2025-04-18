package edu.pnu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Repository;

import com.rubypaper.jdbc.config.JDBCConnectionManagerProperties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
@EnableConfigurationProperties(Connecter2.class)
public class JDBCConnect {
	
	@Autowired
	private Connecter2 conConfig;
	private Connection con;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement psmt = null;


	@PostConstruct
	public void init() {
	    try {
	        Class.forName(conConfig.getDriver());
	        con = DriverManager.getConnection(conConfig.getUrl(), conConfig.getUsername(), conConfig.getPwd());
	        System.out.println("DB연결 성공");
	    } catch (Exception e) {
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
