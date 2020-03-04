package com.controller.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.beans.food.Customer;
import com.beans.food.Employee;
import com.beans.food.Food;
import com.food.dao.FoodDb;

/**
 * Servlet implementation class AdminControllerServlet
 */
@WebServlet("/AdminController")
@MultipartConfig(maxFileSize = 16177215)
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodDb foodDb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		foodDb = new FoodDb();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private void savefood(HttpServletRequest request, HttpServletResponse response) throws Exception, ServletException {
		// TODO Auto-generated method stub
		String selectedCatagory = request.getParameter("selectedCatagory");

		String newCatagory = request.getParameter("newcatagory");
		String food_name = request.getParameter("foodname");
		int food_price = Integer.parseInt(request.getParameter("foodprice").toString());
		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}
		if (!newCatagory.isEmpty()) {
			System.out.println("newcatagory = " + newCatagory + " " + inputStream + " found");
			Food food = new Food(newCatagory, food_name, food_price, inputStream);
			foodDb.saveNewFood(food);
		} else if (newCatagory.isEmpty()) {
			System.out.println("selected catagory = " + selectedCatagory + " found");
			Food food = new Food(selectedCatagory, food_name, food_price, inputStream);
			foodDb.saveNewFood(food);
		}
		autoSearch(request, response);
	}

	private void addfood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<String> listCatagory = new ArrayList<String>();
		listCatagory = foodDb.getCatagories();
		request.setAttribute("CATAGORY_LIST", listCatagory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add-food.jsp");
		dispatcher.forward(request, response);
	}

	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email.equals("sufian@gmail.com") && password.equals("12345")) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			autoSearch(request, response);
		} else {
			response.sendRedirect("admin-login.jsp");
		}
	}

	public void autoSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> listCatagory = new ArrayList<String>();
		List<Food> listFood = new ArrayList<Food>();
		listCatagory = foodDb.getCatagories();
		if (listCatagory.size() >= 1) {
			request.setAttribute("CATAGORY_LIST", listCatagory);
			String catagory = listCatagory.get(0);
			request.setAttribute(catagory, "");
			listFood = foodDb.getFood(catagory);
			request.setAttribute("FOOD_LIST", listFood);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-panel.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void searchByCatagory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String catagory = request.getParameter("selectedcatagory");
		request.setAttribute("selected", catagory);
		List<Food> listFood = new ArrayList<Food>();
		List<String> listCatagory = new ArrayList<String>();
		listCatagory = foodDb.getCatagories();
		listFood = foodDb.getFood(catagory);
		request.setAttribute("CATAGORY_LIST", listCatagory);
		request.setAttribute("FOOD_LIST", listFood);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-panel.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		switch (command) {
		case "ADMIN_LOGIN":
			try {
				adminLogin(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "SEARCH":
			try {
				searchByCatagory(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "VIEW_FOOD":
			try {
				autoSearch(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "ADD_FOOD":
			try {
				addfood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "SAVE_FOOD":
			try {
				savefood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "LOAD_FOOD":
			try {
				loadFood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "UPDATE_FOOD":
			try {
				updateFood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "DELETE_FOOD":
			try {
				deleteFood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "LOAD_ALL_FOOD":
			try {
				showAllFood(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "LOAD_ALL_ORDERS":
			try {
				loadAllOrders(request, response);
			} catch (Exception exception) {

			}
			break;
		case "LOAD_CUSTOMER":
			try {
				loadCustomer(request, response);
			} catch (Exception exception1) {
				// TODO Auto-generated catch block
				exception1.printStackTrace();
			}
			break;
		case "UPDATE_CUSTOMER":
			try {
				updateCustomer(request, response);
			} catch (SQLException exception1) {
				// TODO Auto-generated catch block
				exception1.printStackTrace();
			}
			break;
		case "DELETE_CUSTOMER":
			try {
				deleteCustomer(request, response);
			} catch (SQLException exception1) {
				// TODO Auto-generated catch block
				exception1.printStackTrace();
			}
			break;
		case "LOGOUT":
			try {
				logout(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "VIEW_EMPLOYEE":
			try {
				viewEmployee(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "SAVE_EMPLOYEE":
			try {
				saveEmployee(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "LOAD_EMPLOYEE":
			try {
				loadEmployee(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "UPDATE_EMPLOYEE":
			try {
				updateEmployee(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		case "DELETE_EMPLOYEE":
			try {
				deleteEmployee(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===delete employee called====");

		int id = Integer.parseInt(request.getParameter("id"));
		foodDb.deleteEmployee(id);
		viewEmployee(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===update employee called====");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		int salary = Integer.parseInt(request.getParameter("salary"));
		Employee employee = new Employee(id,name, address, contact, salary);
		employee.toString();
		foodDb.updateEmployee(employee, id);
		viewEmployee(request, response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===load employee called====");

		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = foodDb.getEmployee(id);
		System.out.println(employee.toString());
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/load-employee.jsp");
		dispatcher.forward(request, response);
	}

	private void saveEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===save employee called====");

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		int salary = Integer.parseInt(request.getParameter("salary"));
		Employee employee = new Employee(name, address, contact, salary);
		foodDb.saveEmployee(employee);
		viewEmployee(request, response);
	}

	private void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> list = foodDb.getAllEmployee();
		System.out.println(list.toString());
		request.setAttribute("employee", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-employee.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		foodDb.deleteCustomer(id);
		loadAllOrders(request, response);
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("update = " + id);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cell = request.getParameter("cell");
		int advance = Integer.parseInt(request.getParameter("advance"));
		int due = Integer.parseInt(request.getParameter("due"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		String service = request.getParameter("servicetype");
		int n = Integer.parseInt(request.getParameter("advance"));
		Customer customer = new Customer(name, address, cell, advance, due, cost, service, n);
		System.out.println(customer.toString());
		foodDb.updateCustomer(customer, id);
		loadAllOrders(request, response);
	}

	private void loadCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id = " + id);
		Customer customer = foodDb.getCustomerById(id);
		System.out.println(customer.toString());
		request.setAttribute("customer", customer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-customer.jsp");
		dispatcher.forward(request, response);
	}

	private void loadAllOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Customer> list = foodDb.getAllCustomer();
		System.out.println(list.size());
		request.setAttribute("orders", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/all-orders.jsp");
		dispatcher.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeController");
		dispatcher.forward(request, response);
	}

	private void showAllFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Food> listAllFood = new ArrayList<Food>();
		listAllFood = foodDb.getAllfood();
		request.setAttribute("FOOD_LIST", listAllFood);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/all-food-admin.jsp");
		dispatcher.forward(request, response);
	}

	private void updateFood(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String catagory = request.getParameter("catagory");
		String foodName = request.getParameter("foodname");
		System.out.println("2 = " + catagory + " " + foodName + " ");
		int foodPrice = Integer.parseInt(request.getParameter("foodprice"));
		System.out.println("2 = " + catagory + " " + foodName + " " + foodPrice);
		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}	
		Food food = new Food(id, catagory, foodName, foodPrice, inputStream);
		foodDb.update(food);
		autoSearch(request, response);
	}

	private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		foodDb.deleteById(id);
		autoSearch(request, response);
	}

	private void loadFood(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Food food = foodDb.getFoodById(id);
		request.setAttribute("food", food);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-delete.jsp");
		dispatcher.forward(request, response);
	}
	

}
