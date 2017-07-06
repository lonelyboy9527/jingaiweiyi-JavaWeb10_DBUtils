package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itheima.jdbc.utils.C3P0Utils;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class TestC3P0 {
	
	@Test
	public void testAddUser1(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//2.从连接池中获取连接
			conn = C3P0Utils.getConnection();
			String sql = "INSERT INTO tbl_user VALUES (null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "曹操2");
			pstmt.setString(2, "是谁啊？");
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
	
	
	@Test
	public void testAddUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//1.使用C3P0创建连接池对象
		DataSource dataSource = new ComboPooledDataSource();//加载默认的配置
		DataSource dataSource2 = new ComboPooledDataSource("itheima");//或者加载有名称的配置
		try {
			//2.从连接池中获取连接
			conn = dataSource.getConnection();
			String sql = "INSERT INTO tbl_user VALUES (null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "曹操");
			pstmt.setString(2, "是谁？");
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
