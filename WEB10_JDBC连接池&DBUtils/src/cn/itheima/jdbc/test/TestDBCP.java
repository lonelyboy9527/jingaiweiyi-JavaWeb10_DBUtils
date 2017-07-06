package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itheima.jdbc.utils.DBCPUtils;

public class TestDBCP {
	@Test
	public void testUpdateUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBCPUtils.getConnection();
			String sql = "UPDATE tbl_user SET upassword=? WHERE uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "14lkdsa");
			pstmt.setInt(2, 5);
			int rows = pstmt.executeUpdate();
			if (rows>0) {
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
