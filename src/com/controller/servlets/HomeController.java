package com.controller.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.food.Customer;
import com.beans.food.Food;
import com.food.dao.FoodDb;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodDb foodDb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
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

	public void autoSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> listCatagory = new ArrayList<String>();
		List<Food> listFood = new ArrayList<Food>();
		listCatagory = foodDb.getCatagories();
		if (listCatagory.size() >= 1) {
			request.setAttribute("CATAGORY_LIST", listCatagory);
			String catagory = listCatagory.get(0);
			listFood = foodDb.getFood(catagory);
			request.setAttribute("FOOD_LIST", listFood);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void searchByCatagory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String catagory = request.getParameter("selectedcatagory");
		request.setAttribute("selected", catagory);
		List<Food> listFood = new ArrayList<Food>();
		List<String> listCatagory = new ArrayList<String>();
		listCatagory = foodDb.getCatagories();
		request.setAttribute("CATAGORY_LIST", listCatagory);
		listFood = foodDb.getFood(catagory);
		request.setAttribute("FOOD_LIST", listFood);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String command = request.getParameter("command");
			System.out.println(command);
			if (command == null)
				command = "home";
			switch (command) {
			case "home":
				autoSearch(request, response);
				break;
			case "LOAD_ALL_FOOD":
				showAllFood(request, response);
				break;
			case "SEARCH":
				searchByCatagory(request, response);
				break;
			case "PURCHASE_FOOD":
				manipulateSelectedFood(request, response);
				break;
			case "USER_SELECTED_FOOD":
				getUserSelectedFoods(request, response);
				break;
			case "LOAD_FOOD_TABLE":
				showFoodsForBookingTable(request, response);
				break;
			case "SELECTED_FOOD_TABLE":
				bookingTable(request, response);
				break;
			case "BOOK_TABLE":
				finishBookingTable(request, response);
				break;
			default:
				autoSearch(request, response);
				break;
			}

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}

	private void finishBookingTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getParameterValues("checkbox") == null) {
			System.out.println("customer....." + request.getParameter("selectedcatagory"));
			autoSearch(request, response);
		} else {
			String[] id = request.getParameterValues("checkbox");
			String[] numberOfFood = request.getParameterValues("numFood");
			String foods="";
			List<Food> list = new ArrayList<Food>();
			for (String n : id) {
				list.add(foodDb.getFoodById(Integer.parseInt(n)));
				foods+=n;
				foods+=",";
			}
			foods=foods.substring(0, foods.length()-1);
			request.setAttribute("FOOD_LIST", list);
			int sum = 0;
			int n = 0;
			for (int i = 0; i < list.size(); i++) {
				sum = sum + (list.get(0).getFoodPrice() * Integer.parseInt(numberOfFood[i]));
				n = n + Integer.parseInt(numberOfFood[i]);
			}
			int advance = Integer.parseInt(request.getParameter("advancepayment"));
			String contact = request.getParameter("contact");
			int persons = Integer.parseInt(request.getParameter("persons"));
			int due = 0;
			if (advance <= sum)
				due = sum - advance;
			//System.out.println(customer.toString());
			FoodDb foodDb = new FoodDb();
			try {
			//foodDb.saveCustomer(customer);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view-sell.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void bookingTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (request.getParameterValues("checkbox") == null) {
			autoSearch(request, response);
		} else {
			String[] id = request.getParameterValues("checkbox");
			String[] numberOfFood = new String[id.length];
			List<Food> list = new ArrayList<Food>();
			int j = 0;
			for (String n : id) {
				list.add(foodDb.getFoodById(Integer.parseInt(n)));
				numberOfFood[j] = request.getParameter(n);
				System.out.println("n = " + numberOfFood[j] + " ==========");
				j++;
			}
			List<Food> list2 = new ArrayList<Food>();
			for (int i = 0; i < list.size(); i++) {
				list2.add(new Food(list.get(i).getId(), list.get(i).getCatagory(), list.get(i).getFoodName(),
						list.get(i).getFoodPrice(), list.get(i).getBase64Image(), numberOfFood[i]));
			}
			request.setAttribute("FOOD_LIST", list2);
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum = sum + (list.get(0).getFoodPrice() * Integer.parseInt(numberOfFood[i]));
			}
			request.setAttribute("cost", sum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/complete-book-table.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void showFoodsForBookingTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<String> listCatagory = new ArrayList<String>();
		List<Food> listFood = new ArrayList<Food>();
		listCatagory = foodDb.getCatagories();
		if (listCatagory.size() >= 1) {
			request.setAttribute("CATAGORY_LIST", listCatagory);
			String catagory = listCatagory.get(0);
			listFood = foodDb.getFood(catagory);
			request.setAttribute("FOOD_LIST", listFood);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/book-table.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void showAllFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Food> listAllFood = new ArrayList<Food>();
		listAllFood = foodDb.getAllfood();
		request.setAttribute("ALL_FOOD_LIST", listAllFood);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/all-food.jsp");
		dispatcher.forward(request, response);
	}

	private void manipulateSelectedFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("manipulate called.......................");
		if (request.getParameterValues("checkbox") == null) {
			System.out.println("customer....." + request.getParameter("selectedcatagory"));
			autoSearch(request, response);
		} else {
			String[] id = request.getParameterValues("checkbox");
			String[] numberOfFood = request.getParameterValues("numFood");
			List<Food> list = new ArrayList<Food>();
			for (String n : id) {
				list.add(foodDb.getFoodById(Integer.parseInt(n)));
			}
			request.setAttribute("FOOD_LIST", list);
			int sum = 0;
			int n = 0;
			for (int i = 0; i < list.size(); i++) {
				sum = sum + (list.get(0).getFoodPrice() * Integer.parseInt(numberOfFood[i]));
				n = n + Integer.parseInt(numberOfFood[i]);
			}
			int advance = Integer.parseInt(request.getParameter("advancepayment"));
			String name = request.getParameter("customername");
			String address = request.getParameter("customeraddress");
			String cellNo = request.getParameter("customercellno");
			String service = request.getParameter("servicetype");
			int due = 0;
			if (advance <= sum)
				due = sum - advance;
			Customer customer = new Customer(name, address, cellNo, advance, due, sum, service, n);
			System.out.println(customer.toString());
			FoodDb foodDb = new FoodDb();
			try {
				foodDb.saveCustomer(customer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view-sell.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void getUserSelectedFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (request.getParameterValues("checkbox") == null) {
			autoSearch(request, response);
		} else {
			String[] id = request.getParameterValues("checkbox");
			String[] numberOfFood = new String[id.length];
			List<Food> list = new ArrayList<Food>();
			int j = 0;
			for (String n : id) {
				list.add(foodDb.getFoodById(Integer.parseInt(n)));
				numberOfFood[j] = request.getParameter(n);
				System.out.println("n = " + numberOfFood[j] + " ==========");
				j++;
			}
			List<Food> list2 = new ArrayList<Food>();
			for (int i = 0; i < list.size(); i++) {
				list2.add(new Food(list.get(i).getId(), list.get(i).getCatagory(), list.get(i).getFoodName(),
						list.get(i).getFoodPrice(), list.get(i).getBase64Image(), numberOfFood[i]));
			}
			request.setAttribute("FOOD_LIST", list2);
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum = sum + (list.get(0).getFoodPrice() * Integer.parseInt(numberOfFood[i]));
			}
			request.setAttribute("cost", sum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sell-food.jsp");
			dispatcher.forward(request, response);
		}
	}
}
