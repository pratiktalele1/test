package com.bl.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Hello World!");
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");

			final String url = "jdbc:mysql://localhost:3306/payroll_service";
			final String userName = "root";
			final String password = "Pratik@22";

			Connection connection = DriverManager.getConnection(url, userName, password);

			System.out.println("Database is connected");

			Statement statement = connection.createStatement();
			String query = "select * from employee_payroll;";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				System.out.println(resultSet.getString(1) + "->" + resultSet.getString(2) + "->"
						+ resultSet.getString(3) + "->" + resultSet.getString(4) + "->" + resultSet.getString(5));
			}

		} catch (SQLException e) {
			System.out.println("Database is not available or not connected");
		}

	}
}
