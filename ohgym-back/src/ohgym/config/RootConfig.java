package ohgym.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:/ohgym/config/datasource.properties")
public class RootConfig {
	// 스프링 이엘
	@Value("${mysql.driverClassName}")
	private String driverClassName;
	@Value("${mysql.url}")
	private String url;
	@Value("${mysql.userName}")
	private String userName;
	@Value("${mysql.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		
		return ds;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager txManager (DataSource dataSource) {
		JdbcTransactionManager txManager = new JdbcTransactionManager(dataSource);
		return txManager;
	}
}
