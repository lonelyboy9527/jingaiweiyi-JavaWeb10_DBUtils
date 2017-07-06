package cn.itheima.jdbc.test;

import java.awt.List;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itheima.domain.User;
import cn.itheima.jdbc.utils.C3P0Utils;
/* DBUtils的查询操作*/
public class TestDbUtils2 {
	/* 使用DBUtils
	 * 查询所有用户 操作*/
	@Test
	public void testQueryAll(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "SELECT * FROM tbl_user";
		try {
			//3.执行查询操作 
			java.util.List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			//4.遍历结果集
			for (User user : users) {
				System.out.println(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	/* 使用DBUtils
	 * 查询所有用户 操作*/
	@Test
	public void testQueryAll1(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "SELECT * FROM tbl_user";
		try {
			//3.执行查询操作 
			java.util.List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	/* 获取某一列数据*/
	@Test
	public void testQueryAll2(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "SELECT * FROM tbl_user";
		try {
			//3.执行查询操作 
			java.util.List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
			for (Object object : list) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* 使用DBUtils
	 * 根据uid查询用户 操作*/
	@Test
	public void testQueryUserById(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "SELECT * FROM tbl_user WHERE uid=?";
		Object[] params = {5};
		try {
			//3.执行查询操作 
			User user = qr.query(sql, new BeanHandler<User>(User.class),params);
			System.out.println(user);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	/* 使用DBUtils
	 * 查询所有用户的个数操作*/
	@Test
	public void testQueryCount(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "SELECT count(*) FROM tbl_user";

		try {
			//3.执行查询操作 
			Long count = (Long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
