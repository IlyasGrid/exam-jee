package com.estf.exam.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.estf.exam.beans.Todo;

public class TodoDaoMemory implements TodoDao {

	private List<Todo> todos;

	public TodoDaoMemory() {
		todos = new Vector<Todo>();
//		save(new Todo("rdv dentiste", 0));
//		save(new Todo("rdv docteur", 1));
	}

	@Override
	public Todo save(Todo todo) {
		todos.add(todo);
		return todo;
	}

	@Override
	public Todo get(String id) {

		for (Todo element : todos)
			if (element.getId().equals(id))
				return element;
		return null;
	}

	@Override
	public List<Todo> getAll() {
		return todos;
	}

	@Override
	public Todo update(Todo todo) {
		Todo u = get(todo.getId());
		if (u == null)
			return null;
		u.setpriority(todo.getpriority());
		u.setTitle(todo.getTitle());
		return u;
	}

	@Override
	public Todo delete(Todo todo) {
		System.out.println(todo.toString());
		Todo element = get(todo.getId());
		if (element == null)
			return null;

		todos.remove(element);
		return element;
	}

	@Override
	public List<Todo> changePriority(Todo todo, String UpOrDown) {

//		System.out.println("before "+todos.toString());
		if (UpOrDown.toUpperCase().equals("UP")) {

			Todo privousTodo = todos.get(todos.indexOf(todo) - 1);
			if (privousTodo == null) {
				return todos;
			}else {
				privousTodo.setpriority(todo.getpriority());

				todo.setpriority(todo.getpriority() - 1);

				Collections.swap(todos, todos.indexOf(todo), todos.indexOf(privousTodo));
			}


		} else if (UpOrDown.toUpperCase().equals("DOWN")) {

			Todo nextTodo = todos.get(todos.indexOf(todo) + 1);
			if (nextTodo == null) {
				return todos;
			}else {
				nextTodo.setpriority(todo.getpriority());
				todo.setpriority(todo.getpriority() + 1);
				Collections.swap(todos, todos.indexOf(todo), todos.indexOf(nextTodo));
			}

		}
//		System.out.println("after "+todos.toString());
		return todos;
	}

}
