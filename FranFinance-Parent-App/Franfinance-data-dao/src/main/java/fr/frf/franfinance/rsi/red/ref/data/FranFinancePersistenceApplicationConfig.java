/**
 * 
 */
package fr.frf.franfinance.rsi.red.ref.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * @author yanndeungoue
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan( basePackages= {"fr.frf.franfinance.rsi.red.ref.data.repository.impl"})
@PropertySource("classpath:application.properties")
public class FranFinancePersistenceApplicationConfig {

	@Autowired
	private Environment environment;
	
	@Bean(autowire=Autowire.BY_NAME, name="dataSource")
	public DataSource dataSource(){
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/franfinance");
		dataSource.setUser("dpassyann");
		dataSource.setPassword("deungoue");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
}
