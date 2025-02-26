package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.EmpDTO;

public class EmpDAO {
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
					System.out.println("\nDB 연결 성공2");
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		public ArrayList<EmpDTO> selectAll() {
			ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
			try {
				connect();
				String sql = "select * from emp";
				
				psmt = conn.prepareStatement(sql);
				rset = psmt.executeQuery();
				while(rset.next()) {
					EmpDTO empDTO = new EmpDTO( rset.getInt("empno"), rset.getString("ename"), rset.getInt("sal"));
					list.add(empDTO);
					
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
			return list;
		}
		
		
	}

