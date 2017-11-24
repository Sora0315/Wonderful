package tw.com.reinbach.wonderful.tools.springORM;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import tw.com.reinbach.wonderful.member.bean.MemberBean;
import tw.com.reinbach.wonderful.order.bean.OrdStatusBean;
import tw.com.reinbach.wonderful.order.bean.OrderBean;
import tw.com.reinbach.wonderful.order.dao.OrdStatusDAO;
import tw.com.reinbach.wonderful.product.bean.ProdStatusBean;
import tw.com.reinbach.wonderful.product.bean.ProductBean;

@Configuration
@ComponentScan("tw.com.reinbach.wonderful")
public class SpringJavaConfig {

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = null;
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/wonderfulDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		// prop.put("hibernate.transaction.coordinator_class", "jdbc");
		prop.put("hibernate.current_session_context_class", "thread");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");

		builder.addProperties(prop);
		builder.addAnnotatedClasses(MemberBean.class, OrderBean.class, OrdStatusBean.class, ProductBean.class,
				ProdStatusBean.class);

		return builder.buildSessionFactory();
	}

}
