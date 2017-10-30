package tw.com.reinbach.wonderful.tools.springORM;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan("tw.com.reinbach.wonderful")
public class SpringJavaConfig {
	
	@Bean
	public DataSource dataSource(){
		DataSource dataSource = null;
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/wonderfulDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder.addFile("hibernate.cfg.xml");
		
		return builder.buildSessionFactory();
	}
	

}
