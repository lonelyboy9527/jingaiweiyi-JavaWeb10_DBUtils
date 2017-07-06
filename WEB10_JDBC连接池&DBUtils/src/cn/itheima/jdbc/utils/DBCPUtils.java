package cn.itheima.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	static {
		try {
			//1.加载配置文件，获得文件流
			InputStream ins = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
			//2.处理配置文件
			Properties props = new Properties();
			props.load(ins);
			
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			System.out.println(driver + "+" + url + "+" + username + "+" + password);
			//3.使用工具类创建连接池
			dataSource = BasicDataSourceFactory.createDataSource(props);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
