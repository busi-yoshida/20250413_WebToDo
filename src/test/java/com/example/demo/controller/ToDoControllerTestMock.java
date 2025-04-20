package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.ToDo;
import com.example.demo.form.ToDoForm;
import com.example.demo.helper.ToDoHelper;
import com.example.demo.service.ToDoService;

@WebMvcTest(ToDoController.class)
public class ToDoControllerTestMock {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockitoBean
	ToDoService toDoService;
	
	@Test
	void test_list() throws Exception{
		ToDoForm toDoForm1 = new ToDoForm();
		toDoForm1.setTodo("test123");
		ToDoForm toDoForm2 = new ToDoForm();
		ToDo ToDoConvert1 = ToDoHelper.convertToDo(toDoForm1);
		ToDo ToDoConvert2 = ToDoHelper.convertToDo(toDoForm2);
		List<ToDo> toDoConvers = new ArrayList<ToDo>();
		toDoConvers.add(ToDoConvert1);
		toDoConvers.add(ToDoConvert2);
		doReturn(toDoConvers).when(toDoService).findAllToDo();
		
		mockMvc.perform(
				get("/todos")
		)
		.andExpect(status().isOk())
		.andExpect(view().name("todo/list"))
		.andExpect(content().string(containsString("test123")))
		;
	}

	@Test
	void test_detail() throws Exception{
		ToDoForm toDoForm = new ToDoForm();
		toDoForm.setTodo("test456");
		ToDo ToDoConvert = ToDoHelper.convertToDo(toDoForm);
		doReturn(ToDoConvert).when(toDoService).findByIdToDo(1);
		
		mockMvc.perform(
				get("/todos/{id}", "1")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("todo/detail"))
		.andExpect(content().string(containsString("test456")))
		;
	}
	
	@Test
	void test_validate() throws Exception {
		mockMvc.perform(
				get("/todos/confirm")
		)
		.andExpect(view().name("todo/form"))
		.andExpect(model().attributeHasFieldErrorCode("toDoForm", "todo", "NotBlank"))
		;
	}

}
