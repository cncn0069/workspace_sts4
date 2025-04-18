package edu.pnu.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.common.Connecter;
import edu.pnu.common.JDBCConnect;
import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao extends JDBCConnect {

	String query;

	public Map<String, Object> getAllMembers() {
		Map<String, Object> map = new HashMap<>();

		query = "SELECT ID, NAME ,PASS, REGIDATE FROM BOOTMISSTION.member";
		map.put("sqlstring", query);

		List<MemberVO> lists = new ArrayList<>();

		try {
			setStmt(getCon().createStatement());
			map.put("regidate", java.sql.Date.valueOf(LocalDate.now()));
			map.put("method", "GET");

			setRs(getStmt().executeQuery(query));

			while (getRs().next()) {
				MemberVO dto = new MemberVO();

				dto.setId(getRs().getInt("ID"));
				dto.setName(getRs().getString("NAME"));
				dto.setPass(getRs().getString("PASS"));
				dto.setRegidate(getRs().getDate("REGIDATE"));

				lists.add(dto);
			}

			map.put("lists", lists);
			map.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("success", false);
			e.printStackTrace();
		}

		close();

		return map;
	}

	public Map<String, Object> getMember(Integer id) {
		Map<String, Object> map = new HashMap<>();

		query = "SELECT ID, NAME ,PASS, REGIDATE FROM BOOTMISSTION.member WHERE id = ?";

		MemberVO dto = new MemberVO();

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setInt(1, id);
			// 실행

			// 로그 관련
			String sqlstring = getPsmt().toString().split(":")[1];
			map.put("sqlstring", sqlstring);
			map.put("method", "GET");
			map.put("regidate", java.sql.Date.valueOf(LocalDate.now()));

			setRs(getPsmt().executeQuery());

			getRs().next();

			dto.setId(getRs().getInt("ID"));
			dto.setName(getRs().getString("NAME"));
			dto.setPass(getRs().getString("PASS"));
			dto.setRegidate(getRs().getDate("REGIDATE"));

			map.put("list", dto);
			map.put("success", true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}
		// 여기서 콘을 닫아 버리면 처음 생성된 con가 사라지므로 ...
		close();

		return map;
	}

	// 더하기
	public Map<String, Object> addMember(MemberVO memberVO) {
		Map<String, Object> map = new HashMap<>();

		query = "INSERT INTO BOOTMISSTION.MEMBER(NAME ,PASS, REGIDATE) VALUES (?,?,?)";

		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setString(1, memberVO.getName());
			getPsmt().setString(2, memberVO.getPass());
			getPsmt().setDate(3, java.sql.Date.valueOf(LocalDate.now()));

			String sqlstring = getPsmt().toString().split(":")[1];
			map.put("sqlstring", sqlstring);
			map.put("method", "POST");
			map.put("regidate", java.sql.Date.valueOf(LocalDate.now()));

			result = getPsmt().executeUpdate();
			map.put("result", result);
			map.put("success", true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}

		close();

		return map;
	}

	public Map<String, Object> updateMember(MemberVO memberVO) {
		Map<String, Object> map = new HashMap<>();

		query = "UPDATE BOOTMISSTION.MEMBER SET NAME = ?, PASS = ? WHERE id = ?";

		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setString(1, memberVO.getName());
			getPsmt().setString(2, memberVO.getPass());
			getPsmt().setInt(3, memberVO.getId());

			String sqlstring = getPsmt().toString().split(":")[1];
			map.put("sqlstring", sqlstring);
			map.put("method", "PUT");
			map.put("regidate", java.sql.Date.valueOf(LocalDate.now()));

			result = getPsmt().executeUpdate();

			map.put("result", result);
			map.put("success", true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}

		close();

		return map;
	}

	public Map<String, Object> deleteMember(Integer id) {
		Map<String, Object> map = new HashMap<>();
		query = "DELETE FROM BOOTMISSTION.MEMBER WHERE id = ?";

		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setInt(1, id);

			String sqlstring = getPsmt().toString().split(":")[1];
			map.put("sqlstring", sqlstring);
			map.put("method", "DEL");
			map.put("regidate", java.sql.Date.valueOf(LocalDate.now()));

			result = getPsmt().executeUpdate();

			map.put("result", result);
			map.put("success", true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success", false);
		}

		this.close();

		return map;
	}

}
