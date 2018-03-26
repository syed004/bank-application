package com.bellinfo.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.bellinfo.spring.model.Student;

@Component
public class StudentRepository {
	Connection con = null;
	private static final String CREATE_TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS STUDENT_DATA(Name varchar(20)  UNIQUE,Password varchar(20),fees real,year integer,gpa integer)";
	private static final String INSERT_INVOICE_RECORD = "INSERT INTO STUDENT_DATA VALUES(?,?,?,?,?)";
	private static final String VALIDATE_PASSWORD = "SELECT password FROM student_data WHERE name=?";

	public DataSource datasource() {

		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUrl("jdbc:postgresql://bellinfo.c3rbut2zylxn.us-east-1.rds.amazonaws.com:5432/Bellinfo");
		datasource.setUsername("rahmath8121");
		datasource.setPassword("Intern8121!");
		return datasource;
	}

	private JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource());
		return jdbcTemplate;

	}

	public void persistStudentData(Student student) {
		JdbcTemplate template = jdbcTemplate();
		template.execute(CREATE_TABLE_STRUCTURE);
		template.update(INSERT_INVOICE_RECORD, student.getName(), student.getPassword(), student.getFees(),
				student.getGpa(), student.getYear());

		System.out.println("inserted student data");

	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://bellinfo.c3rbut2zylxn.us-east-1.rds.amazonaws.com:5432/Bellinfo", "rahmath8121",
					"Intern8121!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean persistStudentvalidation(Student s2) {
		System.out.println("student validation in process");
		boolean password = validateStudent(s2);
		return password;

	}

	private boolean validateStudent(Student s2) {
		boolean password = false;
		JdbcTemplate template = jdbcTemplate();
		Student stud=new Student("", "");
		try {
			stud = template.queryForObject(VALIDATE_PASSWORD, new Object[] {s2.getName()}, 
					new RowMapper<Student>() {

						public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
							Student stud=new Student("","");
							stud.setPassword(arg0.getString(1));
							System.out.println(stud.toString());
							return stud;
						}});
			if (stud.getPassword().equals(s2.getPassword())) {
				password = true;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(password+stud.getPassword());
		return password;
	}
}
