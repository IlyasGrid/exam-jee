package com.estf.exam.dao;

import java.util.List;

import com.estf.exam.beans.Todo;

public interface TodoDao {
	Todo save(Todo todo);

	Todo get(String id);

	List<Todo> getAll();

	Todo update(Todo todo);

	Todo delete(Todo todo);
}
