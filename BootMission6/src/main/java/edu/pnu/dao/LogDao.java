package edu.pnu.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.common.JDBCConnect;
import edu.pnu.domain.MemberVO;

@Repository
public class LogDao extends JDBCConnect {

	public void addLog(Map<String, Object> map) {
		
		String query = "INSERT INTO bootmisstion.dblog(method,sqlstring,regidate,success)"
				+ "VALUES (?,?,?,?)";
		
		try {
			setPsmt(getCon().prepareStatement(query));
			getPsmt().setString(1, (String)map.get("method"));
			getPsmt().setString(2, (String)map.get("sqlstring"));
			getPsmt().setDate(3, (java.sql.Date)map.get("regidate") );
			getPsmt().setBoolean(4, (boolean)map.get("success"));
			
			getPsmt().executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
