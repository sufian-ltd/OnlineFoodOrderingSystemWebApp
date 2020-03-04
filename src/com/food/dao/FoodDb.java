package com.food.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import com.beans.food.Customer;
import com.beans.food.Employee;
import com.beans.food.Food;

@MultipartConfig(maxFileSize = 16177215)
public class FoodDb {

	public List<String> getCatagories() throws SQLException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getCon();
			String query = "select distinct catagory from food";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String catagory_name = resultSet.getString("catagory");
				list.add(catagory_name);
			}
			return list;
		}

		finally {

			close(connection, statement, resultSet);
		}
	}

	public List<Food> getAllfood() throws SQLException, IOException {
		// TODO Auto-generated method stub
		List<Food> list = new ArrayList<Food>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getCon();
			String query = "SELECT id,food_name,food_price,food_image from food";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String food_name = resultSet.getString("food_name");
				int price = resultSet.getInt("food_price");
				Blob food_image = resultSet.getBlob("food_image");
				InputStream inputStream = food_image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				Food food = new Food(id, food_name, price, base64Image);
				list.add(food);
			}
			return list;
		}

		finally {

			close(connection, statement, resultSet);
		}
	}

	private void close(Connection connection, Statement statement, ResultSet resultSet) {
		// TODO Auto-generated method stub

		try {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Food> getFood(String catagory) throws SQLException, Exception {
		// TODO Auto-generated method stub
		List<Food> list = new ArrayList<Food>();
		Food food = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getCon();
			String query = "select * from food where catagory=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, catagory);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String food_name = resultSet.getString("food_name");
				int food_price = resultSet.getInt("food_price");
				// Part food_image=(Part) resultSet.getBlob("food_image");
				Blob food_image = resultSet.getBlob("food_image");

				InputStream inputStream = food_image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				food = new Food(id, catagory, food_name, food_price, base64Image);
				list.add(food);
			}
			return list;
		}

		finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void saveNewFood(Food food) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DB.getCon();
			String query = "insert into food (catagory,food_name,food_price,food_image) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			System.out.println(food.getCatagory());
			preparedStatement.setString(1, food.getCatagory());
			preparedStatement.setString(2, food.getFoodName());
			preparedStatement.setInt(3, food.getFoodPrice());
			preparedStatement.setBlob(4, food.getFoodImage());
			preparedStatement.execute();

		} finally {
			// TODO: handle exception
			close(connection, preparedStatement, null);
		}
	}

	public void saveFoodBycatagory(Food food, String selectedCatagory) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DB.getCon();
			String query = "INSERT INTO food (food_name, food_price,food_image)" + " VALUES(?,?,?) WHERE catagory=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, food.getFoodName());
			preparedStatement.setInt(2, food.getFoodPrice());
			preparedStatement.setBlob(3, food.getFoodImage());
			preparedStatement.setString(4, selectedCatagory);
			preparedStatement.executeUpdate(query);

		} finally {
			// TODO: handle exception
			close(connection, preparedStatement, null);
		}
	}

	public Food getFoodById(int id) throws Exception {
		// TODO Auto-generated method stub
		Food food = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getCon();
			String query = "select * from food where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String catagory = resultSet.getString("catagory");
				String food_name = resultSet.getString("food_name");
				int food_price = resultSet.getInt("food_price");
				Blob food_image = resultSet.getBlob("food_image");
				InputStream inputStream = food_image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				food = new Food(id, catagory, food_name, food_price, base64Image);
			}
			return food;
		}

		finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// get db connection
			connection = DB.getCon();
			String query = "delete from food where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} finally {
			close(connection, preparedStatement, null);
		}
	}

	public void update(Food food) throws Exception {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = DB.getCon();

			// create SQL update statement
			String sql = "update food " + "set catagory=?, food_name=?, food_price=? " + "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, food.getCatagory());
			myStmt.setString(2, food.getFoodName());
			myStmt.setInt(3, food.getFoodPrice());
			myStmt.setInt(4, food.getId());

			// execute SQL statement
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void saveCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DB.getCon();
			String query = "insert into customer(name,address,cell,advance,due,cost,"
					+ "service,numoffood) values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setString(3, customer.getCellNo());
			preparedStatement.setInt(4, customer.getAdvancePayment());
			preparedStatement.setInt(5, customer.getDue());
			preparedStatement.setInt(6, customer.getCost());
			preparedStatement.setString(7, customer.getService());
			preparedStatement.setInt(8, customer.getNumberOfFood());
			preparedStatement.execute();

		} finally {
			// TODO: handle exception
			close(connection, preparedStatement, null);
		}
	}

	public List<Customer> getAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DB.getCon();
			String query = "select * from customer";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String cellNo = resultSet.getString("cell");
				int advance = resultSet.getInt("advance");
				int due = resultSet.getInt("due");
				int cost = resultSet.getInt("cost");
				String service = resultSet.getString("service");
				int numOfFood = resultSet.getInt("numoffood");
				Customer customer = new Customer(id, name, address, cellNo, advance, due, cost, service, numOfFood);
				list.add(customer);
			}
			return list;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public Customer getCustomerById(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try {
			connection = DB.getCon();
			String query = "select * from customer where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String cellNo = resultSet.getString("cell");
				int advance = resultSet.getInt("advance");
				int due = resultSet.getInt("due");
				int cost = resultSet.getInt("cost");
				String service = resultSet.getString("service");
				int numOfFood = resultSet.getInt("numoffood");
				customer = new Customer(id, name, address, cellNo, advance, due, cost, service, numOfFood);
			}
			return customer;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void updateCustomer(Customer customer, int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement preparedStatement = null;

		try {
			// get db connection
			myConn = DB.getCon();

			// create SQL update statement
			String sql = "update customer " + "set name=?, address=?, cell=? , advance=?, due=?, cost=?,"
					+ " service=?, numoffood=?" + " where id=?";

			// prepare statement
			preparedStatement = myConn.prepareStatement(sql);

			// set params
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setString(3, customer.getCellNo());
			preparedStatement.setInt(4, customer.getAdvancePayment());
			preparedStatement.setInt(5, customer.getDue());
			preparedStatement.setInt(6, customer.getCost());
			preparedStatement.setString(7, customer.getService());
			preparedStatement.setInt(8, customer.getNumberOfFood());
			preparedStatement.setInt(9, id);

			// execute SQL statement
			preparedStatement.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, preparedStatement, null);
		}
	}

	public void deleteCustomer(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// get db connection
			connection = DB.getCon();
			String query = "delete from customer where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} finally {
			close(connection, preparedStatement, null);
		}
	}

	public List<Employee> getAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			connection = DB.getCon();
			String query = "select * from employee";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String contact = resultSet.getString("contact");
				int salary = resultSet.getInt("salary");
				Employee employee = new Employee(id, name, address, contact, salary);
				list.add(employee);
			}
			return list;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void saveEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DB.getCon();
			String query = "insert into employee(name,address,contact,salary) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setString(3, employee.getContact());
			preparedStatement.setInt(4, employee.getSalary());
			preparedStatement.execute();

		} finally {
			// TODO: handle exception
			close(connection, preparedStatement, null);
		}
	}

	public Employee getEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			connection = DB.getCon();
			String query = "select * from employee where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String contact = resultSet.getString("contact");
				int salary = resultSet.getInt("salary");
				employee = new Employee(id, name, address, contact, salary);
			}
			return employee;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void updateEmployee(Employee employee, int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement preparedStatement = null;

		try {
			// get db connection
			myConn = DB.getCon();

			// create SQL update statement
			String sql = "update employee " + "set name=?, address=?, contact=? , salary=? where id=?";

			// prepare statement
			preparedStatement = myConn.prepareStatement(sql);

			// set params
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setString(3, employee.getContact());
			preparedStatement.setInt(4, employee.getSalary());
			preparedStatement.setInt(5, id);

			// execute SQL statement
			preparedStatement.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, preparedStatement, null);
		}
	}

	public void deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// get db connection
			connection = DB.getCon();
			String query = "delete from employee where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} finally {
			close(connection, preparedStatement, null);
		}
	}

}
