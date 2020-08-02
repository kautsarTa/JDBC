package jdbc;

import java.sql.*;

public class Course {

	private String code;
	private String courseName;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean storeData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?autoReconnect=false&useSSL=false","root", "0162413618Kr_92");
			String sql = "INSERT INTO courses (code, course_name) VALUES (?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, getCode());
			statement.setString(2, getCourseName());
			statement.executeUpdate();
			statement.close();
			con.close();
			return true;	
			
		}catch(Exception ex) {
			return false;
		}
		
	}
	public boolean updateData(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?autoReconnect=false&useSSL=false","root", "0162413618Kr_92");
			String sql = "UPDATE courses SET code =?, course_name = ?  WHERE course_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, getCode());
			statement.setString(2, getCourseName());
			statement.setInt(3, id);
			statement.executeUpdate();
			statement.close();
			con.close();
			return true;
			
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	public boolean deleteData(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?autoReconnect=false&useSSL=false","root", "0162413618Kr_92");
			String sql = "DELETE From courses WHERE course_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			con.close();
			return true;
			
			
		}catch(Exception ex) {
			return false;
		}
	}
	
}
