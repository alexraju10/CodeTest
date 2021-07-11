package com.codetask.todolist.pojo;

public class ToDoItem {
	
	private String itemName;
	private boolean completed;
	private boolean deleted;
	private boolean tag;
	private String reminder;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isTag() {
		return tag;
	}
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	
	

}
