package com.estf.exam.business;

import java.util.List;

import com.estf.exam.beans.Todo;
import com.estf.exam.dao.TodoDao;
import com.estf.exam.dao.TodoDaoMemory;



public class DefaultService implements Service{
	private static DefaultService instance = null;
	public static DefaultService getInstance() {
		if(instance==null)
			instance=new DefaultService(new TodoDaoMemory());
		return instance;
	}
	
	private TodoDao todoDao;
	private DefaultService(TodoDao todoDao) {
		this.todoDao=todoDao;
	}
	@Override
	public Todo addTodo(Todo todo) {
		return todoDao.save(todo);
	}

	@Override
	public Todo updateTodo(Todo todo) {
		return todoDao.update(todo);
	}

	@Override
	public Todo deleteTodo(Todo todo) {
		return todoDao.delete(todo);
	}

	@Override
	public Todo getTodo(String id) {
		return todoDao.get(id);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoDao.getAll();
	}

}
