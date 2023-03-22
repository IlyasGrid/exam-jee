package com.estf.exam.presentation.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.estf.exam.beans.Todo;
import com.estf.exam.business.DefaultService;

@WebServlet("/AddTodoServleet")
public class AddTodoServleet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Todo> todos = new ArrayList();


	public AddTodoServleet() throws ClassNotFoundException {
		super();
		this.todos = DefaultService.getInstance().getAllTodos();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("addTodo.jsp").forward(request, response);;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title;
	    
		if ( request.getParameter("Todotitle") != null && !request.getParameter("Todotitle").equals("")) {


			title = request.getParameter("Todotitle");
			
			DefaultService.getInstance().addTodo(new Todo(title,todos.size()));
						
		    request.setAttribute("msg", "todo added");
		    request.getRequestDispatcher("addTodo.jsp").forward(request, response);
		} else {

			request.setAttribute("msg", " try valid inputs ");
			request.getRequestDispatcher("addTodo.jsp").forward(request, response);
		}
	}

}
