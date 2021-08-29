package castisvn.configurations;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DatasourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);
	@Autowired
	private Environment environment;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	@Bean
	public DataSource datasource() {
		String activeProfile = environment.getActiveProfiles()[0];
		driverClassName = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/hr_manager";
		username = "root";
		password = "chainos2021";
		if("localTest".equals(activeProfile)){
			driverClassName = "com.mysql.cj.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/hr_manager_local";
			username = "root";
			password = "chainos2021";
		}
		if("serverTest".equals(activeProfile)){
			driverClassName = "com.mysql.cj.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/hr_manager_server";
			username = "root";
			password = "chainos2021";
		}
		logger.info("Active profile=" + activeProfile);
		logger.info("driverClassName=" + driverClassName );
		logger.info("url=" + url );
		return DataSourceBuilder.create()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.build();
	}
}