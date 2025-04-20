package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoMapper;
import com.example.demo.service.impl.ToDoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceImplTestMock {
	@InjectMocks
	ToDoServiceImpl toDoServiceImpl;
	
	@Mock
	ToDoMapper toDoMapper;
	
	@Test
	void test_findByIdToDo() {
		ToDo toDo = new ToDo();
		toDo.setTodo("test123");
		doReturn(toDo).when(toDoMapper).selectById(1);
		
		ToDo actual= toDoServiceImpl.findByIdToDo(1);
		assertThat(actual.getTodo()).isEqualTo("test123");
	}
	
	@Test
	void test_findAllToDo() {
		List<ToDo> todos = new ArrayList<ToDo>();
		ToDo todo1 = new ToDo();
		ToDo todo2 = new ToDo();
		todos.add(todo1);
		todos.add(todo2);
		doReturn(todos).when(toDoMapper).selectAll();
		
		List<ToDo> actuals = toDoServiceImpl.findAllToDo();
		assertThat(actuals.size()).isEqualTo(2);
	}
	

}
