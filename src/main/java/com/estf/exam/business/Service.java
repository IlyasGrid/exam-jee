package com.estf.exam.business;

import java.util.List;

import com.estf.exam.beans.Todo;

public interface Service {

	public Todo addTodo(Todo todo);
	public Todo updateTodo(Todo todo);
	public Todo deleteTodo(Todo todo);
	public Todo getTodo(String id);
	public List<Todo> changePriority(Todo todo, String UpOrDwon);
	public List<Todo> getAllTodos();
}
