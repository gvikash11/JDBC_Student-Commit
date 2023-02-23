package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.Student;

import com.jsp.helper.HelperClass;

public class StudentDao {
	HelperClass helperclass =new HelperClass();
	Connection connection = helperclass.getConnection();
	PreparedStatement preparedStatement = null;
	public Student savaStudent(Student student) {
		Connection connection=helperclass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,student.getId());
			preparedStatement.setString(2,student.getName());
			preparedStatement.setString(3,student.getEmail());
			preparedStatement.execute();
			connection.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("Executed");
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	public Student deleteStudentById(Student student) {
		String sql = "DELETE FROM STUDENT WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			System.out.println("Data is sucessfully deleted...");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection closed ...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	public Student updateStudentById(Student student) {
		String sql = "UPDATE STUDENT SET NAME='DAVID' WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			System.out.println("Data is sucessfully updated...");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection closed ...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}
	public void showStudents(String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				System.out.println(resultset.getInt(1) + "--" + resultset.getString(2) + "--" + resultset.getString(3));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Student> addMultipleStudents(List<Student> students){
		HelperClass helperclass=new HelperClass();
		
		Connection connection=helperclass.getConnection();
		String sql="INSERT INTO teacher VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			for(Student s:students) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("All good");
			connection .close();
		}
		catch(SQLException e) {
			System.out.println("Executed");
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return students;
	}
}
