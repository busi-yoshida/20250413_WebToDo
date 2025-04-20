package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ToDo;
import com.example.demo.form.ToDoForm;
import com.example.demo.helper.ToDoHelper;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class ToDoServiceImplTest {
	
	@Autowired
	ToDoService toDoService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void test_findByIdToDo() {
		ToDo todo = toDoService.findByIdToDo(1);
		assertThat(todo.getTodo()).isEqualTo("買い物");
	}
	
	@Test
	void test_findAllToDo() {
		List<ToDo> todos = toDoService.findAllToDo();
		assertThat(todos.size()).isEqualTo(4);
	}
	
	@Test
	void test_orderForm() {
		ToDoForm toDoForm = new ToDoForm();
		toDoForm.setTodo("test123");
		toDoForm.setDetail("test456");		
		ToDo ToDoConvert = ToDoHelper.convertToDo(toDoForm);
		toDoService.insertToDo(ToDoConvert);
		
        List<Map<String, Object>> todoMap = jdbcTemplate.queryForList("select * from todos");
        assertThat(todoMap.size()).isEqualTo(5);
	}

}
