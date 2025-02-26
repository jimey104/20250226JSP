package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.DeptDTO;

public class DeptDAO {
	// DB 연결 정보
	private static final String DRIVER	= "com.mysql.cj.jdbc.Driver";
	private static final String URL		= "jdbc:mysql://localhost:3307/spring5fs?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private static final String USER	= "root";
	private static final String PASS	= "1234";
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rset;
	
	public void connect(){
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			if(conn!=null) {
				System.out.println("\nDB 연결 성공1");
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public ArrayList<DeptDTO> selectAll() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		try {
			connect();
			String sql = "select * from dept";
			
			psmt = conn.prepareStatement(sql);
			rset = psmt.executeQuery();
			while(rset.next()) {
				DeptDTO deptDTO = new DeptDTO( rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
				list.add(deptDTO);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}
	
	
}
