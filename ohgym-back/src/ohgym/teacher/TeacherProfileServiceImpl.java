package ohgym.teacher;

import java.sql.Connection;
import java.sql.SQLException;

import ohgym.dbutil.ConnectionProvider;

public class TeacherProfileServiceImpl implements TeacherProfileService {
	private TeacherDAO dao;
	
	public TeacherProfileServiceImpl(TeacherDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public TeacherProfile readTeacherProfile(String userId) {
		String id = null;
		String name = null;
		String exerciseType = null;
		String introduction = null;
		String location = null;
		String employees = null;
		String career = null;
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			TeacherInfo teacher = dao.selectInfoById(conn, userId);
			String appeal = teacher.getAppeal();
			String contactTime = teacher.getContact_time();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new TeacherProfile("경연", "스포애니", "피티", "피티피티", "부산시 부산진구 부전동4", "20명", "5년 6개월");
	}
}
