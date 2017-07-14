package mx.com.allianz;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("application.properties")
public class DemoApplicationIntegrationTestingApplicationConfiguration {

	@Value("${db.Username}")
	private String dbUsername;
	
	@Value("${db.Password}")
	private String dbPassword;
	
	@Value("${db.Server}")
	private String dbServer;
	
	@Value("${db.Port}")
	private int dbPort;
	
	@Value("${db.database}")
	private String dbDataBase;
	
	@Value("${db.URL}")
	private String dbURL;
	
	@Bean
	public DataSource getOracleDataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		
		dataSource.setServerName(this.dbServer);
		dataSource.setPortNumber(this.dbPort);
		dataSource.setDatabaseName(this.dbDataBase);
		dataSource.setUser(this.dbUsername);
		dataSource.setPassword(this.dbPassword);
		dataSource.setURL(this.dbURL);
		
		return dataSource;
	}
	
	
}
