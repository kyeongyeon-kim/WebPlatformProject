package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class RequestInfoDAO {
	List<Integer> requestNoList;
	
	public RequestInfoDAO() {}

	public RequestInfoDAO(List<Integer> requestNoList) {
		super();
		this.requestNoList = requestNoList;
	}

	public List<RequestInfo> requestInfoList(String user_id){
		List<RequestInfo> reqInfoList = new ArrayList<>();
		requestNoList = new ArrayList<>();
		requestNoFind(user_id);
		
		for (int i = 0; i < requestNoList.size(); i++) {
			reqInfoList.add(requestInfo(requestNoList.get(i)));
		}
		
		return reqInfoList;
	}
	
	public List<RequestInfo> requestAll() {
		List<RequestInfo> reqInfoList = new ArrayList<>();
		requestNoList = new ArrayList<>();
		
		String sql = "SELECT request_no FROM request";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requestNoList.add((int)rs.getInt("request_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < requestNoList.size(); i++) {
			reqInfoList.add(requestInfo(requestNoList.get(i)));
		}
		
		return reqInfoList;
	}
	
	public void requestNoFind(String user_id) {
		String sql = "SELECT request_no FROM request WHERE user_id = '" + user_id + "'";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requestNoList.add((int)rs.getInt("request_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void requestAnswerFind(int requestNo, RequestInfo reqInfo) {
		String sql = "SELECT * FROM request_answer WHERE request_no = " + requestNo;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				switch (rs.getInt("question")) {
					case 1:
						if (reqInfo.getAnswer1() == null) {
							reqInfo.setAnswer1(rs.getString("answer"));
						} else {
							reqInfo.setAnswer1(reqInfo.getAnswer1() + "," + rs.getString("answer"));
						}
						break;
					case 2:
						if (reqInfo.getAnswer2() == null) {
							reqInfo.setAnswer2(rs.getString("answer"));
						} else {
							reqInfo.setAnswer2(reqInfo.getAnswer2() + "," + rs.getString("answer"));
						}
						break;
					case 3:
						if (reqInfo.getAnswer3() == null) {
							reqInfo.setAnswer3(rs.getString("answer"));
						} else {
							reqInfo.setAnswer3(reqInfo.getAnswer3() + "," + rs.getString("answer"));
						}
						break;
					case 4:
						if (reqInfo.getAnswer4() == null) {
							reqInfo.setAnswer4(rs.getString("answer"));
						} else {
							reqInfo.setAnswer4(reqInfo.getAnswer4() + "," + rs.getString("answer"));
						}
						break;
					case 5:
						if (reqInfo.getAnswer5() == null) {
							reqInfo.setAnswer5(rs.getString("answer"));
						} else {
							reqInfo.setAnswer5(reqInfo.getAnswer5() + "," + rs.getString("answer"));
						}
						break;
					case 6:
						if (reqInfo.getAnswer6() == null) {
							reqInfo.setAnswer6(rs.getString("answer"));
						} else {
							reqInfo.setAnswer6(reqInfo.getAnswer6() + "," + rs.getString("answer"));
						}
						break;
					case 7:
						if (reqInfo.getAnswer7() == null) {
							reqInfo.setAnswer7(rs.getString("answer"));
						} else {
							reqInfo.setAnswer7(reqInfo.getAnswer7() + "," + rs.getString("answer"));
						}
						break;
					default:
						break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void requestFind(int requestNo, RequestInfo reqInfo) {
		String sql = "SELECT * FROM request WHERE request_No = " + requestNo;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				reqInfo.setRequest_no(rs.getInt("request.request_no"));
				reqInfo.setUser_id(rs.getString("user_id"));
				reqInfo.setExercise_type(rs.getString("exercise_type"));
				reqInfo.setRequest_date(rs.getString("request_date"));
				reqInfo.setDeadline_date(rs.getString("deadline_date"));
				reqInfo.setMessage(rs.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public RequestInfo requestInfo(int requestNo) {
		RequestInfo reqInfo = new RequestInfo();
		requestFind(requestNo, reqInfo);
		requestAnswerFind(requestNo, reqInfo);
		
		return reqInfo;
	}
}