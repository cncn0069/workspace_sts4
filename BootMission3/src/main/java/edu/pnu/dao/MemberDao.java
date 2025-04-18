package edu.pnu.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.common.JDBCConnect;
import edu.pnu.domain.MemberVO;

public class MemberDao extends JDBCConnect {

	public List<MemberVO> getAllMembers(){

		String query = "SELECT ID, NAME ,PASS, REGIDATE FROM BOOTMISSTION.member";
		List<MemberVO> lists = new ArrayList<>();
		try {
			setStmt(getCon().createStatement());

			setRs(getStmt().executeQuery(query));

			while (getRs().next()) {
				MemberVO dto = new MemberVO();

				dto.setId(getRs().getInt("ID"));
				dto.setName(getRs().getString("NAME"));
				dto.setPass(getRs().getString("PASS"));
				dto.setRegidate(getRs().getDate("REGIDATE"));

				lists.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		close();

		return lists;
	}

	public MemberVO getMember(Integer id) {

		String query = "SELECT ID, NAME ,PASS, REGIDATE FROM BOOTMISSTION.member WHERE id = ?";
		MemberVO dto = new MemberVO();

		try {
			setPsmt(getCon().prepareStatement(query));
			getPsmt().setInt(1, id);
			// 실행

			setRs(getPsmt().executeQuery());
			getRs().next();

			dto.setId(getRs().getInt("ID"));
			dto.setName(getRs().getString("NAME"));
			dto.setPass(getRs().getString("PASS"));
			dto.setRegidate(getRs().getDate("REGIDATE"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 여기서 콘을 닫아 버리면 처음 생성된 con가 사라지므로 ...
		close();

		return dto;
	}

	// 더하기
	public int addMember(MemberVO memberVO) {

		String query = "INSERT INTO BOOTMISSTION.MEMBER(NAME ,PASS, REGIDATE) VALUES (?,?,?)";
		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setString(1, memberVO.getName());
			getPsmt().setString(2, memberVO.getPass());
			getPsmt().setDate(3, java.sql.Date.valueOf(LocalDate.now()));

			result = getPsmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();

		return result;
	}

	public int updateMember(MemberVO memberVO) {

		String query = "UPDATE BOOTMISSTION.MEMBER SET NAME = ?, PASS = ? WHERE id = ?";
		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setString(1, memberVO.getName());
			getPsmt().setString(2, memberVO.getPass());
			getPsmt().setInt(3, memberVO.getId());

			result = getPsmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();

		return result;
	}

	public int deleteMember(Integer id) {
		String query = "DELETE FROM BOOTMISSTION.MEMBER WHERE id = ?";
		int result = 0;

		try {
			setPsmt(getCon().prepareStatement(query));

			getPsmt().setInt(1, id);

			result = getPsmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.close();

		return result;
	}

}
