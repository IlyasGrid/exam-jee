package com.estf.exam.presentation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.estf.exam.beans.Todo;
import com.estf.exam.business.DefaultService;

@WebServlet("/ListTodoServlet")
public class ListTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Todo> todos = new ArrayList<Todo>();

	public ListTodoServlet() throws ClassNotFoundException {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.todos = DefaultService.getInstance().getAllTodos();
		for (Todo todo : todos) {
			todo.toString();
		}
		request.setAttribute("mylist", todos);
		request.getRequestDispatcher("ListTodo.jsp").forward(request, response); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("idToDelete") == null && req.getParameter("idPriority") == null) {
			doGet(req, resp);
		} else {
			if (req.getParameter("idPriority") == null) {
				
				doDelete(req, resp);
				
			} else if(req.getParameter("idToDelete") == null ) {
				
				DefaultService.getInstance().changePriority(
						DefaultService.getInstance().getTodo(
								req.getParameter("idPriority")),
								req.getParameter("UpOrDown"));
				for (Todo todo : todos) {
					System.out.println(todo.getTitle()+"   "+todo.getpriority()+"");	
				}
				
				doGet(req, resp);
			} 
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println(req.getParameter("idToDelete"));

		DefaultService.getInstance().deleteTodo(DefaultService.getInstance().getTodo(req.getParameter("idToDelete")));
		doGet(req, resp);

	}

}
