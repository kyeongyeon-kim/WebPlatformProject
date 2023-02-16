package ohgym.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionProvider {
	private static DataSource dataSource;
	
	static {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/ohgym");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("ohgym");
		ds.setPassword("root");
		
		dataSource = ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}