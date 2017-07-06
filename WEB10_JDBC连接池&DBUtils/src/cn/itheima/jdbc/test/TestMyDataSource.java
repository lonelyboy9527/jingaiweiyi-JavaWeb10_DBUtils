package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itheima.jdbc.DateSource.MyDataSource;
import cn.itheima.jdbc.DateSource.MyDataSource1;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class TestMyDataSource {
	
	
	
	
	/* 添加用户
	 * 使用未改造过的Connection*/
	@Test
	public void testAddUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//创建自定义连接池对象
		MyDataSource dataSource = new MyDataSource();
		try {
			//从连接池中获取连接
			conn = dataSource.getConnection();
			String sql = "INSERT INTO tbl_user VALUES (null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "哈哈风格");
			pstmt.setString(2, "1654231");
			int rows = pstmt.executeUpdate();
			if (rows>0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dataSource.backConnection(conn);
		}
	}  
	/* 添加用户
	 * 使用改造过的Connection*/
	@Test
	public void testAddUser1(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//1.创建自定义连接池对象
		MyDataSource1 dataSource = new MyDataSource1();
		try {
			//2.从连接池中获取连接
			conn = dataSource.getConnection();
			String sql = "INSERT INTO tbl_user VALUES (null,?,?)";
			//3.必须在自定义的Connection中，返回一个sql执行平台
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "哈哈风格");
			pstmt.setString(2, "1654231");
			int rows = pstmt.executeUpdate();
			if (rows>0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}  
}
