package com.example.demo.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.JdbcToDoMapper;

@JdbcTest
//@Sql("ToDoMapperTest.sql")
public class JdbcToDoMapperTestMock {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	JdbcToDoMapper jdbcToDoMapper;	
	
	@BeforeEach
	void setUp() {
		jdbcToDoMapper = new JdbcToDoMapper(jdbcTemplate);
	}
	
	@Test
	void test_selectById() {
		ToDo todo = jdbcToDoMapper.selectById(1);
		assertThat(todo.getTodo()).isEqualTo("買い物");
	}

	@Test
	void test_selectAll() {
		List<ToDo> todos = jdbcToDoMapper.selectAll();
		assertThat(todos.size()).isEqualTo(4);
	}

	@Test
	void test_update() {
		ToDo todo = new ToDo();
		todo.setTodo("自動化のテスト");
		todo.setDetail("上手く動作しているのか？");
		todo.setId(1);
		boolean result = jdbcToDoMapper.update(todo);
		assertThat(result).isEqualTo(true);
		
        Map<String, Object> todoMap = jdbcTemplate.queryForMap(
        "SELECT * FROM todos WHERE id=?", 1);
		
		assertThat(todoMap.get("todo")).isEqualTo("自動化のテスト");
		assertThat(todoMap.get("detail")).isEqualTo("上手く動作しているのか？");
	}
	

}
