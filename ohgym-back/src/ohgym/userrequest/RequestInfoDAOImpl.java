package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;
import ohgym.request.Request;

public class RequestInfoDAOImpl implements RequestInfoDAO {
	@Override
	public List<RequestInfo> selectRequestInfo(Connection conn, String user_id) throws SQLException {
		String sql = "SELECT * FROM request INNER JOIN request_answer ON request.request_no = request_answer.request_no "
				+ "WHERE request.request_no IN (SELECT request_no FROM request WHERE user_id = ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user_id);
			ResultSet rs = stmt.executeQuery();

			List<RequestInfo> list = new ArrayList<>();
			
			List<RequestInfo> subList = new ArrayList<>();
			while (rs.next()) {
				RequestInfo ri = new RequestInfo();
				ri.setRequest_no(rs.getInt("request_no"));
				ri.setUser_id(rs.getString("user_id"));
				ri.setExercise_type(rs.getString("exercise_type"));
				ri.setRequest_date(rs.getString("request_date"));
				ri.setDeadline_date(rs.getString("deadline_date"));
				ri.setMessage(rs.getString("message"));
				switch (Integer.valueOf(rs.getString("question"))) {
					case 1:
						ri.setAnswer1(rs.getString("answer"));
						break;
					case 2:
						ri.setAnswer2(rs.getString("answer"));
						break;
					case 3:
						ri.setAnswer3(rs.getString("answer"));
						break;
					case 4:
						ri.setAnswer4(rs.getString("answer"));
						break;
					case 5:
						ri.setAnswer5(rs.getString("answer"));
						break;
					case 6:
						ri.setAnswer6(rs.getString("answer"));
						break;
					case 7:
						ri.setAnswer7(rs.getString("answer"));
						break;
					default:
						break;
				}
				subList.add(ri);
			}
			list = requestInfoList(subList);
			return list;
		}
	}
	@Override
	public List<RequestInfo> selectRequestInfoNoAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM request INNER JOIN request_answer ON request.request_no = request_answer.request_no "
				+ "WHERE request.request_no IN (SELECT request_no FROM request)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			List<RequestInfo> list = new ArrayList<>();
			
			List<RequestInfo> subList = new ArrayList<>();
			while (rs.next()) {
				RequestInfo ri = new RequestInfo();
				ri.setRequest_no(rs.getInt("request_no"));
				ri.setUser_id(rs.getString("user_id"));
				ri.setExercise_type(rs.getString("exercise_type"));
				ri.setRequest_date(rs.getString("request_date"));
				ri.setDeadline_date(rs.getString("deadline_date"));
				ri.setMessage(rs.getString("message"));
				switch (Integer.valueOf(rs.getString("question"))) {
					case 1:
						ri.setAnswer1(rs.getString("answer"));
						break;
					case 2:
						ri.setAnswer2(rs.getString("answer"));
						break;
					case 3:
						ri.setAnswer3(rs.getString("answer"));
						break;
					case 4:
						ri.setAnswer4(rs.getString("answer"));
						break;
					case 5:
						ri.setAnswer5(rs.getString("answer"));
						break;
					case 6:
						ri.setAnswer6(rs.getString("answer"));
						break;
					case 7:
						ri.setAnswer7(rs.getString("answer"));
						break;
					default:
						break;
				}
				subList.add(ri);
			}
			list = requestInfoList(subList);
			return list;
		}
	}
	public List<RequestInfo> requestInfoList(List<RequestInfo> subList) throws SQLException {
		List<RequestInfo> list = new ArrayList<>();
		
		for (int i = 0; i < subList.size(); i++) {
			if ((i != 0 && subList.get(i - 1).getRequest_no() != subList.get(i).getRequest_no()) || i == 0) {
				RequestInfo ri = new RequestInfo();
				ri.setRequest_no(subList.get(i).getRequest_no());
				ri.setUser_id(subList.get(i).getUser_id());
				ri.setExercise_type(subList.get(i).getExercise_type());
				ri.setRequest_date(subList.get(i).getRequest_date());
				ri.setDeadline_date(subList.get(i).getDeadline_date());
				ri.setMessage(subList.get(i).getMessage());
				ri.setAnswer1(subList.get(i).getAnswer1());
				list.add(ri);
			} else {
				if (subList.get(i).getAnswer1() != null && list.get(list.size() - 1).getAnswer1() != null) {
					list.get(list.size() - 1).setAnswer1(list.get(list.size() - 1).getAnswer1() + "," + subList.get(i).getAnswer1());
				}
				if (subList.get(i).getAnswer2() != null && list.get(list.size() - 1).getAnswer2() == null) {
					list.get(list.size() - 1).setAnswer2(subList.get(i).getAnswer2());
				} else if (subList.get(i).getAnswer2() != null && list.get(list.size() - 1).getAnswer2() != null) {
					list.get(list.size() - 1).setAnswer2(list.get(list.size() - 1).getAnswer2() + "," + subList.get(i).getAnswer2());
				}
				if (subList.get(i).getAnswer3() != null && list.get(list.size() - 1).getAnswer3() == null) {
					list.get(list.size() - 1).setAnswer3(subList.get(i).getAnswer3());
				} else if (subList.get(i).getAnswer3() != null && list.get(list.size() - 1).getAnswer3() != null) {
					list.get(list.size() - 1).setAnswer3(list.get(list.size() - 1).getAnswer3() + "," + subList.get(i).getAnswer3());
				}
				if (subList.get(i).getAnswer4() != null && list.get(list.size() - 1).getAnswer4() == null) {
					list.get(list.size() - 1).setAnswer4(subList.get(i).getAnswer4());
				} else if (subList.get(i).getAnswer4() != null && list.get(list.size() - 1).getAnswer4() != null) {
					list.get(list.size() - 1).setAnswer4(list.get(list.size() - 1).getAnswer4() + "," + subList.get(i).getAnswer4());
				}
				if (subList.get(i).getAnswer5() != null && list.get(list.size() - 1).getAnswer5() == null) {
					list.get(list.size() - 1).setAnswer5(subList.get(i).getAnswer5());
				} else if (subList.get(i).getAnswer5() != null && list.get(list.size() - 1).getAnswer5() != null) {
					list.get(list.size() - 1).setAnswer5(list.get(list.size() - 1).getAnswer5() + "," + subList.get(i).getAnswer5());
				}
				if (subList.get(i).getAnswer6() != null && list.get(list.size() - 1).getAnswer6() == null) {
					list.get(list.size() - 1).setAnswer6(subList.get(i).getAnswer6());
				} else if (subList.get(i).getAnswer6() != null && list.get(list.size() - 1).getAnswer6() != null) {
					list.get(list.size() - 1).setAnswer6(list.get(list.size() - 1).getAnswer6() + "," + subList.get(i).getAnswer6());
				}
				if (subList.get(i).getAnswer7() != null && list.get(list.size() - 1).getAnswer7() == null) {
					list.get(list.size() - 1).setAnswer7(subList.get(i).getAnswer7());
				} else if (subList.get(i).getAnswer7() != null && list.get(list.size() - 1).getAnswer7() != null) {
					list.get(list.size() - 1).setAnswer7(list.get(list.size() - 1).getAnswer7() + "," + subList.get(i).getAnswer7());
				}
			}
		}
		return list;
	}
}