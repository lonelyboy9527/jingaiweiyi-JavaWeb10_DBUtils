package cn.itheima.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itheima.jdbc.utils.C3P0Utils;

/* DBUtils的增删改操作*/
public class TestDbUtils1 {
	/* 使用DBUtils插入操作*/
	@Test
	public void testAddUser(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "INSERT INTO tbl_user VALUES(null,?, ?)";
		//3.为占位符设置值
		Object[] params = {"新插入", "密码123456"};
		try {
			//4.执行添加操作 
			int rows = qr.update(sql, params);
			if (rows>0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	/* 使用DBUtils
	 * 更新用户信息*/
	@Test
	public void testUpdateUserById(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "UPDATE tbl_user SET upassword=? WHERE uid=?";
		//3.为占位符设置值
		Object[] params = {"124211", 6};
		try {
			//4.执行添加操作 
			int rows = qr.update(sql, params);
			if (rows>0) {
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* 使用DBUtils
	 * 删除用户信息*/
	@Test
	public void testDeleteUserById(){
		//1.创建核心类QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//2.编写SQL语句
		String sql = "DELETE FROM tbl_user WHERE uid=?";
		//3.为占位符设置值
		Object[] params = {6};
		try {
			//4.执行添加操作 
			int rows = qr.update(sql, params);
			if (rows>0) {
				System.out.println("删除成功!");
			} else {
				System.out.println("删除失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
