package com.codetask.todolist.main;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import com.codetask.todolist.business.ToDoListManagement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodeTestInvoke {
	
	String toDoListName="";
	String toDoItemName="";
	String toDoItemName1="";
	ToDoListManagement objToDoListManagement=null;
	
	@Before
	public void setUp() throws Exception{
		toDoListName="MorningRun";
		toDoItemName="Coffee";
		toDoItemName1="Get Report";
		objToDoListManagement=new ToDoListManagement();
		
	}
	
	@Test
	public void test1() {
		System.out.println("Test-1: Create To DO List");
		objToDoListManagement.createToDoList(toDoListName);
		objToDoListManagement.addToDoItem(toDoListName, toDoItemName);
		objToDoListManagement.addToDoItem(toDoListName, toDoItemName1);
		assertNotNull(ToDoListManagement.getToDoListMap());
		objToDoListManagement.printToDoLists();
	} 
	
	@Test
	public void test2(){
		System.out.println("\n");
		System.out.println("Test-2: ");
		objToDoListManagement.deleteToDoItem("test", "test1");
		assertNotNull(ToDoListManagement.getToDoListMap());
		objToDoListManagement.printToDoLists();
	}
	
	@Test
	public void test3(){
		System.out.println("\n");
		System.out.println("Test-3: ");
		objToDoListManagement.restoreToDoItem(toDoListName, toDoItemName);
		objToDoListManagement.printToDoLists();
	}

}
