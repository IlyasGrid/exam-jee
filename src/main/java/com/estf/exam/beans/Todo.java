package com.estf.exam.beans;

import java.util.UUID;

public class Todo {

//	static int  priorityIndex =0;
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", priority=" + priority + "]";
	}

	private String id;
	private String title;
	private int priority;

	public Todo() {

	}

	public Todo(String title,int priority) {
		super();
		String uuid = UUID.randomUUID().toString();
		this.id = uuid;
		this.title = title;
		this.priority =priority;
//		this.priority = priorityIndex;
//		priorityIndex++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getpriority() {
		return priority;
	}

	public void setpriority(int priority) {
		this.priority = priority;
	}

}
