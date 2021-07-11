package com.codetask.todolist.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.codetask.todolist.pojo.ToDoItem;
import com.codetask.todolist.pojo.ToDoList;
import com.codetask.todolist.util.CodeTaskUtilities;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ToDoList")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ToDoListManagement {

	private static Map<String, ToDoList> toDoListMap = null;

	public static Map<String, ToDoList> getToDoListMap() {
		return toDoListMap;
	}

	@POST
    @Path("/createToDoList")
	public void createToDoList(String listName) {
		ToDoList objToDoList = null;
		if (listName != null && !"".equals(listName)) {
			if (null == toDoListMap) {
				toDoListMap = new HashMap<String, ToDoList>();
				objToDoList = new ToDoList();
				toDoListMap.put(listName, objToDoList);
			} else {
				objToDoList = new ToDoList();
				toDoListMap.put(listName, objToDoList);
			}
		}
	}

	@POST
    @Path("/addcreateToDoItem")
	public void addToDoItem(String toDoListName, String toDoItemName) {
		ToDoList objToDoList = null;
		if (!CodeTaskUtilities.isNullOrEmptyMap(toDoListMap)) {
			objToDoList = toDoListMap.get(toDoListName);
			addItem(objToDoList, toDoItemName);
		} else {
			createToDoList(toDoListName);
			objToDoList = toDoListMap.get(toDoListName);
			addItem(objToDoList, toDoItemName);
		}
	}

	private void addItem(ToDoList objToDoList, String toDoItemName) {
		ToDoItem objToDoItem = null;
		List<ToDoItem> toDoList = null;
		if (null == objToDoList.getToDoList()) {
			toDoList = new ArrayList<ToDoItem>();
			objToDoItem = new ToDoItem();
			objToDoItem.setItemName(toDoItemName);
			toDoList.add(objToDoItem);
			objToDoList.setToDoList(toDoList);
		} else {
			objToDoItem = new ToDoItem();
			objToDoItem.setItemName(toDoItemName);
			objToDoList.getToDoList().add(objToDoItem);
		}

	}

	@POST
    @Path("/addcreateToDoItem")
	public void markAsCompleted(String toDoListName, String toDoItemnName) {
		ToDoList objToDoList = null;
		objToDoList = toDoListMap.get(toDoListName);
		if (objToDoList != null) {
			for (ToDoItem obj : objToDoList.getToDoList()) {
				if (obj.getItemName().equalsIgnoreCase(toDoItemnName)) {
					obj.setCompleted(true);
				}
			}
		} else {
			System.out.println("No Such To-Do list exist");
		}
	}

	@POST
    @Path("/tagToDoItem")
	public void tagToDoItem(String toDoListName, String toDoItemnName) {
		ToDoList objToDoList = null;
		objToDoList = toDoListMap.get(toDoListName);
		if (objToDoList != null) {
			for (ToDoItem obj : objToDoList.getToDoList()) {
				if (obj.getItemName().equalsIgnoreCase(toDoItemnName)) {
					obj.setTag(true);
				}
			}
		} else {
			System.out.println("No Such To-Do list exist");
		}
	}

	@POST
    @Path("/setReminderToDoItem")
	public void setReminderToDoItem(String toDoListName, String toDoItemnName, String reminderTime) {
		ToDoList objToDoList = null;
		objToDoList = toDoListMap.get(toDoListName);
		if (objToDoList != null) {
			for (ToDoItem obj : objToDoList.getToDoList()) {
				if (obj.getItemName().equalsIgnoreCase(toDoItemnName)) {
					obj.setReminder(reminderTime);
				}
			}
		} else {
			System.out.println("No Such To-Do list exist");
		}

	}

	@POST
    @Path("/deleteToDoItem")
	public void deleteToDoItem(String toDoListName, String toDoItemName) {
		ToDoList objToDoList = null;
		objToDoList = toDoListMap.get(toDoListName);
		if (objToDoList != null) {
			for (ToDoItem obj : objToDoList.getToDoList()) {
				if (obj.getItemName().equalsIgnoreCase(toDoItemName)) {
					obj.setDeleted(true);
				}
			}
		} else {
			System.out.println("No Such To-Do list exist");
		}
	}

	@POST
    @Path("/restoreToDoItem")
	public void restoreToDoItem(String toDoListName, String toDoItemName) {
		ToDoList objToDoList = null;
		objToDoList = toDoListMap.get(toDoListName);
		for (ToDoItem obj : objToDoList.getToDoList()) {
			if (obj.getItemName().equalsIgnoreCase(toDoItemName)) {
				if (obj.isDeleted()) {
					obj.setDeleted(false);
				}
			}
		}
	}

	@GET
    @Path("/printgToDoLists")
	public void printToDoLists() {
		ToDoList objToDoList = null;
		if (!CodeTaskUtilities.isNullOrEmptyMap(getToDoListMap())) {
			Set<String> keySet = getToDoListMap().keySet();
			for (String s : keySet) {
				System.out.println("To Do List : " + s);
				objToDoList = getToDoListMap().get(s);
				for (ToDoItem obj : objToDoList.getToDoList()) {
					if (!obj.isDeleted()) {
						System.out.println("To Do Item Name: " + obj.getItemName());
						System.out.println("Completed :" + obj.isCompleted());
						System.out.println("---------------------------------------");
					}
				}
				System.out.println("***************************************************");
			}
		}

	}

}
